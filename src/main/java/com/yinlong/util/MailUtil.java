package com.yinlong.util;

//import com.gree.scc.sys.vo.Cbase000VO;
import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MailUtil
{
  private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  
  public static Session getSession()
  {
    Session session = null;
    try
    {
      session = (Session)new InitialContext()
        .lookup("mailSession");
    }
    catch (NamingException ex)
    {
      Properties props = new Properties();
      
      props.put("mail.smtp.host", "192.168.2.240");
      props.put("mail.smtp.auth", "false");
      session = Session.getDefaultInstance(props, null);
    }
    return session;
  }
  
  public static void sendMessageWithAttachment(String from, String[] to, String[] cc, String subject, String content, String mimeType, File attachment)
    throws MessagingException
  {
    Message message = new MimeMessage(getSession());
    
    InternetAddress sentFrom = new InternetAddress(from + "@gree.com.cn");
    message.setFrom(sentFrom);
    
    InternetAddress[] sendTo = new InternetAddress[to.length];
    for (int i = 0; i < to.length; i++) {
      sendTo[i] = new InternetAddress(to[i] + "@gree.com.cn");
    }
    if ((cc.length > 0) && (cc[0] != null))
    {
      InternetAddress[] copyTo = new InternetAddress[cc.length];
      for (int i = 0; i < cc.length; i++) {
        copyTo[i] = new InternetAddress(cc[i] + "@gree.com.cn");
      }
      message.setRecipients(Message.RecipientType.CC, copyTo);
    }
    message.setRecipients(Message.RecipientType.TO, sendTo);
    
    message.setSubject(subject);
    
    MimeBodyPart messageBodyPart = new MimeBodyPart();
    
    messageBodyPart.setContent(content, mimeType);
    
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);
    
    messageBodyPart = new MimeBodyPart();
    
    DataSource source = new FileDataSource(attachment);
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(attachment.getName());
    
    multipart.addBodyPart(messageBodyPart);
    
    message.setContent(multipart);
    
    Transport.send(message);
  }
  
  public static void sendMessageWithAttachments(String from, String[] to, String[] cc, String subject, String content, String mimeType, File[] attachment)
    throws MessagingException
  {
    Message message = new MimeMessage(getSession());
    
    InternetAddress sentFrom = new InternetAddress(from + "@gree.com.cn");
    message.setFrom(sentFrom);
    
    InternetAddress[] sendTo = new InternetAddress[to.length];
    for (int i = 0; i < to.length; i++) {
      sendTo[i] = new InternetAddress(to[i] + "@gree.com.cn");
    }
    if ((cc.length > 0) && (cc[0] != null))
    {
      InternetAddress[] copyTo = new InternetAddress[cc.length];
      for (int i = 0; i < cc.length; i++) {
        copyTo[i] = new InternetAddress(cc[i] + "@gree.com.cn");
      }
      message.setRecipients(Message.RecipientType.CC, copyTo);
    }
    message.setRecipients(Message.RecipientType.TO, sendTo);
    
    message.setSubject(subject);
    
    MimeBodyPart messageBodyPart = new MimeBodyPart();
    
    messageBodyPart.setContent(content, mimeType);
    
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);
    for (int i = 0; i < attachment.length; i++)
    {
      messageBodyPart = new MimeBodyPart();
      
      DataSource source = new FileDataSource(attachment[i]);
      messageBodyPart.setDataHandler(new DataHandler(source));
      messageBodyPart.setFileName(attachment[i].getName());
      
      multipart.addBodyPart(messageBodyPart);
    }
    message.setContent(multipart);
    
    Transport.send(message);
  }
  
  public static void sendMessage(String from, String[] to, String[] cc, String subject, String content, String mimeType)
    throws MessagingException
  {
    Message message = new MimeMessage(getSession());
    
    InternetAddress sentFrom = new InternetAddress(from);
    message.setFrom(sentFrom);
    
    InternetAddress[] sendTo = new InternetAddress[to.length];
    for (int i = 0; i < to.length; i++) {
      sendTo[i] = new InternetAddress(to[i]);
    }
    if (cc != null && (cc.length > 0) && (cc[0] != null))
    {
      InternetAddress[] copyTo = new InternetAddress[cc.length];
      for (int i = 0; i < cc.length; i++) {
        copyTo[i] = new InternetAddress(cc[i]);
      }
      message.setRecipients(Message.RecipientType.CC, copyTo);
    }
    message.setRecipients(Message.RecipientType.TO, sendTo);
    
    message.setSubject(subject);
    message.setContent(content, mimeType);
    
    Transport.send(message);
  }
  
  public static void sendTextMessage(String from, String[] to, String[] cc, String subject, String content)
    throws MessagingException
  {
    sendMessage(from, to, cc, subject, content, "text/plain");
  }
  
  public static void sendTextMessage(String from, String to, String cc, String subject, String content)
    throws MessagingException
  {
    String[] recipient = { to };
    String[] copy = { cc };
    sendMessage(from, recipient, copy, subject, content, "text/plain");
  }
  
  public static void sendMessage(String from, String to, String cc, String subject, String content, String mimeType)
    throws MessagingException
  {
    String[] recipient = { to };
    String[] copy = { cc };
    sendMessage(from, recipient, copy, subject, content, mimeType);
  }
  
  public static void sendMessage(String from, String to, String cc, String subject, String content, String mimeType, File attachment)
    throws MessagingException
  {
    String[] recipient = { to };
    String[] copy = { cc };
    sendMessageWithAttachment(from, recipient, copy, subject, content, 
      mimeType, attachment);
  }
  
  public static void sendHTMLMessage(String from, String[] to, String[] cc, String subject, String content)
    throws MessagingException
  {
    sendMessage(from, to, cc, subject, content, "text/html;charset=UTF-8");
  }
  
  public static void sendHTMLMessage(String from, String to, String cc, String subject, String content)
    throws MessagingException
  {
    String[] recipient = { to };
    String[] copy = { cc };
    sendMessage(from, recipient, copy, subject, content, "text/html;charset=UTF-8");
  }
  
  public static void sendmail(String userid, String userid2, String titl, String djno, String notes, int sta1)
    throws MessagingException
  {
    String subject = "";
    
    subject = titl + "(" + djno + ")";
    
    String contentType = "text/html;charset=UTF-8";
    
    String[] to = { userid };
    
    String[] cc = new String[0];
    
    String content = getContent(userid, titl, djno, notes);
    sendMessage("SCCMessager", to, cc, subject, content, contentType);
  }
  
  private static String getContent(String userid, String titl, String cono, String notes)
  {
    return 
    
      "<HTML><HEAD><TITLE>非生产物料集中采购平台</TITLE><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><STYLE type=text/css>BODY {FONT-SIZE: 9pt; MARGIN: 0px; OVERFLOW: auto; FONT-FAMILY: Verdana, Geneva, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #ffffff}BODY {FONT-SIZE: 12px; COLOR: #0377C1; FONT-FAMILY: arial}TABLE {FONT-SIZE: 12px; COLOR: #0377C1; FONT-FAMILY: arial}DIV#default {BORDER-RIGHT: black 0px solid; PADDING-RIGHT: 10px; BORDER-TOP: black 0px solid; PADDING-LEFT: 10px; BACKGROUND: #fff; PADDING-BOTTOM: 20px; MARGIN: 10pt auto 20pt 20pt; BORDER-LEFT: black 0px solid; WIDTH: 700px; PADDING-TOP: 10px; BORDER-BOTTOM: black 0px solid; TEXT-ALIGN: left}</STYLE><BODY><DIV id=default><B>非生产物料集中采购平台系统邮件提示:</B><BR><TABLE width=\"100%\">  <TBODY>  <TR>    <TD colSpan=2> <LI>您好，申购单号: <FONT color=red><U>" + cono + "(" + titl + ") ;" + notes + "</U></FONT> 。 <FONT color=green>注：请及时<A HREF='http://10.1.18.83:8080/scc/index.html'>" + "登录" + "</A>" + "系统处理。</FONT></LI></TD></TR></TR>" + "<TR>" + "<TD colSpan=2>" + "<LI><FONT color=red><B>注:</B></FONT> " + "此邮件为系统信息,请不要作回复操作。</LI></TD></TR></TBODY></TABLE>" + "</DIV></BODY></HTML>";
  }
  
  public static void sendmail_offer(String userid, String djno, String rdsca, String bize, String note)
    throws MessagingException
  {
    String subject = "";
    
    subject = djno + "(" + rdsca + ")";
    
    String contentType = "text/html;charset=UTF-8";
    
    String[] to = { userid };
    
    String[] cc = new String[0];
    
    String content = getContent_offer(userid, rdsca, djno, bize, note);
    sendMessage("SCCMessager", to, cc, subject, content, contentType);
  }
  
  public static void sendmail_ywy(String userid, String nama, String djno, String emil, String suno, String usid)
    throws MessagingException
  {
    String subject = "";
    
    subject = djno + "(" + nama + ")";
    
    String contentType = "text/html;charset=UTF-8";
    
    String[] to = { userid };
    
    String[] cc = { usid };
    
    String content = getContent_ywy(userid, nama, djno, emil, suno);
    sendMessage("SCCMessager", to, cc, subject, content, contentType);
  }
  
  private static String getContent_ywy(String userid, String nama, String djno, String emil, String suno)
  {
    return 
    
      "<HTML><HEAD><TITLE>非生产物料集中采购平台</TITLE><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><STYLE type=text/css>BODY {FONT-SIZE: 9pt; MARGIN: 0px; OVERFLOW: auto; FONT-FAMILY: Verdana, Geneva, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #ffffff}BODY {FONT-SIZE: 12px; COLOR: #0377C1; FONT-FAMILY: arial}TABLE {FONT-SIZE: 12px; COLOR: #0377C1; FONT-FAMILY: arial}DIV#default {BORDER-RIGHT: black 0px solid; PADDING-RIGHT: 10px; BORDER-TOP: black 0px solid; PADDING-LEFT: 10px; BACKGROUND: #fff; PADDING-BOTTOM: 20px; MARGIN: 10pt auto 20pt 20pt; BORDER-LEFT: black 0px solid; WIDTH: 700px; PADDING-TOP: 10px; BORDER-BOTTOM: black 0px solid; TEXT-ALIGN: left}</STYLE><BODY><DIV id=default><B>非生产物料集中采购平台系统邮件提示:</B><BR><TABLE width=\"100%\">  <TBODY>  <TR>    <TD colSpan=2>   您好，" + nama + "（" + emil + "）," + "改供应商已通过获准供货资格，供应商代码为" + suno + "。" + " 。 <FONT color=green>注：请及时<A HREF='http://10.1.18.83:8080/scc/index.html'>" + "登录" + "</A>" + "系统处理。</FONT></LI></TD></TR></TR>" + "<TR>" + "<TD colSpan=2>" + "<LI><FONT color=red><B>注:</B></FONT> " + "此邮件为系统信息,请不要作回复操作。</LI></TD></TR></TBODY></TABLE>" + "</DIV></BODY></HTML>";
  }
  
  private static String getContent_offer(String userid, String rdsca, String djno, String bize, String note)
  {
    return 
    
      "<HTML><HEAD><TITLE>非生产物料集中采购平台</TITLE><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><STYLE type=text/css>BODY {FONT-SIZE: 9pt; MARGIN: 0px; OVERFLOW: auto; FONT-FAMILY: Verdana, Geneva, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #ffffff}BODY {FONT-SIZE: 12px; COLOR: #0377C1; FONT-FAMILY: arial}TABLE {FONT-SIZE: 12px; COLOR: #0377C1; FONT-FAMILY: arial}DIV#default {BORDER-RIGHT: black 0px solid; PADDING-RIGHT: 10px; BORDER-TOP: black 0px solid; PADDING-LEFT: 10px; BACKGROUND: #fff; PADDING-BOTTOM: 20px; MARGIN: 10pt auto 20pt 20pt; BORDER-LEFT: black 0px solid; WIDTH: 700px; PADDING-TOP: 10px; BORDER-BOTTOM: black 0px solid; TEXT-ALIGN: left}</STYLE><BODY><DIV id=default><B>非生产物料集中采购平台系统邮件提示:</B><BR><TABLE width=\"100%\">  <TBODY>  <TR>    <TD colSpan=2>   您好，您有一张编号为：<FONT color=red>" + djno + "</FONT>类型为<FONT color=red>" + rdsca + "</FONT>主题为<FONT color=red>" + bize + "</FONT>的电子审批单未处理" + " 。 <FONT color=green>注：请及时<A HREF='http://10.1.18.83:8080/scc/index.html'>" + "登录" + "</A>" + "系统处理。</FONT></LI></TD></TR></TR>" + "<TR>" + "<TD colSpan=2>" + "<LI><FONT color=red><B>注:</B></FONT> " + "此邮件为系统信息,请不要作回复操作。</LI></TD></TR></TBODY></TABLE>" + "</DIV></BODY></HTML>";
  }
  
  public static void sendmail_manager(Map<String, Object> map)
    throws MessagingException
  {
    String subject = "准入资格审核";
    
    String contentType = "text/html;charset=UTF-8";
    
    String[] to = { (String)map.get("receiverId") };
    
    String[] cc = { (String)map.get("senderId") };
    
    String content = getContent_manager(map.get("providerEmail").toString(), map.get("providerName").toString(), map.get("note").toString());
    
    sendMessage("SCCMessager", to, cc, subject, content, contentType);
  }
  
  private static String getContent_manager(String providerEmail, String providerName, String note)
  {
    String result = "";
    
    result = "<HTML><HEAD><TITLE>非生产物料集中采购平台</TITLE><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><STYLE type=text/css>BODY {FONT-SIZE: 9pt; MARGIN: 0px; OVERFLOW: auto; FONT-FAMILY: Verdana, Geneva, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #ffffff}BODY {FONT-SIZE: 12px; COLOR: #0377C1; FONT-FAMILY: arial}TABLE {FONT-SIZE: 12px; COLOR: #0377C1; FONT-FAMILY: arial}DIV#default {BORDER-RIGHT: black 0px solid; PADDING-RIGHT: 10px; BORDER-TOP: black 0px solid; PADDING-LEFT: 10px; BACKGROUND: #fff; PADDING-BOTTOM: 20px; MARGIN: 10pt auto 20pt 20pt; BORDER-LEFT: black 0px solid; WIDTH: 700px; PADDING-TOP: 10px; BORDER-BOTTOM: black 0px solid; TEXT-ALIGN: left}</STYLE><BODY><DIV id=default><B>非生产物料集中采购平台系统邮件提示:</B><BR><TABLE width=\"100%\">  <TBODY>  <TR>    <TD colSpan=2> <LI> 您好，" + 
    
      providerName + "(" + providerEmail + "),该供应商的审批权限已分配给您，" + 
      " <FONT color=green>请及时<A HREF='http://10.1.18.83:8080/scc/index.html'>" + "登录" + "</A>" + "系统处理。</FONT></LI></TD></TR></TR>" + 
      "<TR>" + 
      "<TD colSpan=2>" + 
      "<LI><FONT color=red><B>注:</B></FONT> " + 
      "此邮件为系统信息,请不要作回复操作。</LI></TD></TR></TBODY></TABLE>" + 
      "</DIV></BODY></HTML>";
    return result;
  }
  
  public static void sendmail1(String receiver, String[] receiver2, String orno, Map map)
    throws MessagingException
  {
    String subject = "";
    
    subject = orno;
    
    String contentType = "text/html;charset=UTF-8";
    
    String[] to = { receiver };
    
    String[] cc = receiver2;
    
    String content = getContent1(orno, map);
    sendMessage("SCCMessager", to, cc, subject, content, contentType);
  }
  /*
  public static void sendmail2(String userid, String userid2, String titl, String orno, String notes, Cbase000VO user, Map map_content, Map map, String flag, int sta1)
    throws MessagingException
  {
    String subject = "";
    
    subject = titl + "(" + orno + ")";
    
    String contentType = "text/html;charset=UTF-8";
    
    String[] to = { userid };
    
    String[] cc = new String[0];
    
    String content = getContent2(orno, user, notes, map_content, map, flag);
    sendMessage("SCCMessager", to, cc, subject, content, contentType);
  }
  
  public static String getContent2(String orno, Cbase000VO user, String notes, Map map_content, Map map, String flag)
  {
    String result = "";
    result = "<HTML><HEAD><TITLE>非生产物料集中采购平台</TITLE><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><STYLE type=text/css>BODY {FONT-SIZE: 9pt; MARGIN: 0px; OVERFLOW: auto; FONT-FAMILY: Verdana, Geneva, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #ffffff}BODY {FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: arial}TABLE {FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: arial}DIV#default {BORDER-RIGHT: black 0px solid; PADDING-RIGHT: 10px; BORDER-TOP: black 0px solid; PADDING-LEFT: 10px; BACKGROUND: #fff; PADDING-BOTTOM: 20px; MARGIN: 10pt auto 20pt 20pt; BORDER-LEFT: black 0px solid; WIDTH: 700px; PADDING-TOP: 10px; BORDER-BOTTOM: black 0px solid; TEXT-ALIGN: left}</STYLE><BODY><DIV id=default><B>非生产物料集中采购平台系统邮件提示:</B><BR><table width=\"100%\"><tr><td align='left'>申购单：</td>";
    if ("1".equals(flag)) {
      result = result + "<td align='left'><font color='orange'>" + orno + "(急)</font></td>";
    } else if ("2".equals(flag)) {
      result = result + "<td align='left'><font color='red'>" + orno + "(特急)</font></td>";
    } else {
      result = result + "<td align='left'>" + orno + "(普通)</td>";
    }
    result = 
    
      result + "</tr><tr><td align='left'>提交人：</td><td align='left'>" + user.getDSCA() + "(" + user.getDEPTDSCA() + ")" + "</td>" + "</tr>" + "<tr>" + "<td align='left'>操作：</td>" + "<td align='left'>" + notes + "</td>" + "</tr>" + "</table>" + "<table width='100%' border=\"1\" class=\"table\" cellpadding=\"0\" cellspacing=\"0\">" + "<tr>" + "<td nowrap class=\"table_td_head\" align='center'>申请人</td>" + "<td nowrap class=\"table_td_head\" align='center'>申请部门</td>" + "<td nowrap class=\"table_td_head\" align='center'>申购类型</td>" + "<td nowrap class=\"table_td_head\" align='center'>申请日期</td>" + "<td nowrap class=\"table_td_head\" align='center'>提交人状态描述</td>" + "</tr>" + "<tr>" + "<td nowrap class=\"t_td\" align='center'>" + map.get("usid_d") + "</td>" + "<td nowrap class=\"t_td\" align='center'>" + map.get("ddsc1") + "</td>" + "<td nowrap class=\"t_td\" align='center'>" + map.get("ptyp_d") + "</td>" + "<td nowrap class=\"t_td\" align='center'>" + map.get("pdat") + "</td>" + "<td nowrap class=\"t_td\" align='center'>" + map.get("stepdsca") + "</td>" + "</tr>" + "</table>" + "<table width='100%' border='1' class='table' cellpadding='0' cellspacing='0'>" + "<tr>" + "<td nowrap class=\"table_td_head\" align='center'>编号</td>" + "<td nowrap class=\"table_td_head\" align='center'>物料代码</td>" + "<td nowrap class=\"table_td_head\" align='center'>物料名称</td>" + "<td nowrap class=\"table_td_head\" align='center'>物料类别</td>" + "<td nowrap class=\"table_td_head\" align='center'>物料规格</td>" + "<td nowrap class=\"table_td_head\" align='center'>数量</td>" + "<td nowrap class=\"table_td_head\" align='center'>单位</td>" + "<td nowrap class=\"table_td_head\" align='center'>预算价</td>" + "<td nowrap class=\"table_td_head\" align='center'>品牌产地</td>" + "<td nowrap class=\"table_td_head\" align='center'>否决原因</td>" + "</tr>";
    String nama = "";String maso = "";String ctyp = "";String quan = "";String unit = "";String pri1 = "";String suno_dsca = "";String flag_ = "";
    String sta2 = "";String note = "";
    nama = map_content.get("nama") == null ? "" : map_content.get("nama").toString();
    maso = map_content.get("maso") == null ? "" : map_content.get("maso").toString();
    ctyp = map_content.get("ctyp") == null ? "" : map_content.get("ctyp").toString();
    quan = map_content.get("quan") == null ? "" : map_content.get("quan").toString();
    unit = map_content.get("unit") == null ? "" : map_content.get("unit").toString();
    pri1 = map_content.get("pri1") == null ? "" : map_content.get("pri1").toString();
    flag_ = map_content.get("flag") == null ? "" : map_content.get("flag").toString();
    suno_dsca = map_content.get("bpcd") == null ? "" : map_content.get("bpcd").toString();
    sta2 = map_content.get("sta2") == null ? "" : map_content.get("sta2").toString();
    note = map_content.get("note") == null ? "" : map_content.get("note").toString();
    
    result = result + "<tr>";
    if ("1".equals(flag_))
    {
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + map_content.get("adid") + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + map_content.get("item") + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + nama + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + maso + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + ctyp + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + quan + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + unit + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + pri1 + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + suno_dsca + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + note + "</font></td>";
    }
    else if ("2".equals(flag_))
    {
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + map_content.get("adid") + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + map_content.get("item") + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + nama + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + maso + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + ctyp + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + quan + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + unit + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + pri1 + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + suno_dsca + "</font></td>";
      result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + note + "</font></td>";
    }
    else
    {
      result = result + "<td nowrap class=\"t_td\" align='center'>" + map_content.get("adid") + "</td>";
      result = result + "<td nowrap class=\"t_td\" align='center'>" + map_content.get("item") + "</td>";
      result = result + "<td nowrap class=\"t_td\" align='center'>" + nama + "</td>";
      result = result + "<td nowrap class=\"t_td\" align='center'>" + maso + "</td>";
      result = result + "<td nowrap class=\"t_td\" align='center'>" + ctyp + "</td>";
      result = result + "<td nowrap class=\"t_td\" align='center'>" + quan + "</td>";
      result = result + "<td nowrap class=\"t_td\" align='center'>" + unit + "</td>";
      result = result + "<td nowrap class=\"t_td\" align='center'>" + pri1 + "</td>";
      result = result + "<td nowrap class=\"t_td\" align='center'>" + suno_dsca + "</td>";
      result = result + "<td nowrap class=\"t_td\" align='center'>" + note + "</td>";
    }
    result = result + "</tr>";
    result = result + "</table>";
    result = result + "<table>";
    result = result + "<tr>";
    result = result + "<td colSpan=9><FONT color=green>注：请及时<A HREF='http://10.1.18.83:8080/scc/index.html'>登录</A>系统处理。</FONT></td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td colSpan=9><B>注:</B></FONT>此邮件为系统信息,请不要作回复操作。</td>";
    result = result + "</tr>";
    result = result + "</table>";
    
    result = result + "</DIV></BODY></HTML>";
    System.out.println(result);
    return result;
  }
  
  public static void sendmail2_(String[] userid, String userid2, String titl, String orno, String opra, String notes, Cbase000VO user, List list, Map map, String flag, int sta1)
    throws MessagingException
  {
    String subject = "";
    
    subject = titl + "(" + orno + ")";
    
    String contentType = "text/html;charset=UTF-8";
    
    String[] to = userid;
    
    String[] cc = new String[0];
    
    String content = getContent2_(orno, user, opra, notes, list, map, flag);
    sendMessage("SCCMessager", to, cc, subject, content, contentType);
  }
  
  public static String getContent2_(String orno, Cbase000VO user, String opra, String notes, List list, Map map, String flag)
  {
    String result = "";
    result = "<HTML><HEAD><TITLE>非生产物料集中采购平台</TITLE><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><STYLE type=text/css>BODY {FONT-SIZE: 9pt; MARGIN: 0px; OVERFLOW: auto; FONT-FAMILY: Verdana, Geneva, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #ffffff}BODY {FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: arial}TABLE {FONT-SIZE: 12px; COLOR: #000000; FONT-FAMILY: arial}DIV#default {BORDER-RIGHT: black 0px solid; PADDING-RIGHT: 10px; BORDER-TOP: black 0px solid; PADDING-LEFT: 10px; BACKGROUND: #fff; PADDING-BOTTOM: 20px; MARGIN: 10pt auto 20pt 20pt; BORDER-LEFT: black 0px solid; WIDTH: 700px; PADDING-TOP: 10px; BORDER-BOTTOM: black 0px solid; TEXT-ALIGN: left}</STYLE><BODY><DIV id=default><B>非生产物料集中采购平台系统邮件提示:</B><BR><table width=\"100%\"><tr><td align='left'>申购单：</td>";
    if ("1".equals(flag)) {
      result = result + "<td align='left'><font color='orange'>" + orno + "(急)</font></td>";
    } else if ("2".equals(flag)) {
      result = result + "<td align='left'><font color='red'>" + orno + "(特急)</font></td>";
    } else {
      result = result + "<td align='left'>" + orno + "(普通)</td>";
    }
    result = 
    
      result + "</tr><tr><td align='left'>提交人：</td><td align='left'>" + user.getDSCA() + "(" + user.getDEPTDSCA() + ")" + "</td>" + "</tr>" + "<tr>" + "<td align='left'>操作：</td>" + "<td align='left'>" + opra + "</td>" + "</tr>" + "<tr>" + "<td align='left'>审批意见：</td>" + "<td align='left'>" + notes + "</td>" + "</tr>" + "</table>" + "<table width='100%' border=\"1\" class=\"table\" cellpadding=\"0\" cellspacing=\"0\">" + "<tr>" + "<td nowrap class=\"table_td_head\" align='center'>申请人</td>" + "<td nowrap class=\"table_td_head\" align='center'>申请部门</td>" + "<td nowrap class=\"table_td_head\" align='center'>申购类型</td>" + "<td nowrap class=\"table_td_head\" align='center'>申请日期</td>" + "<td nowrap class=\"table_td_head\" align='center'>提交人状态描述</td>" + "</tr>" + "<tr>" + "<td nowrap class=\"t_td\" align='center'>" + map.get("usid_d") + "</td>" + "<td nowrap class=\"t_td\" align='center'>" + map.get("ddsc1") + "</td>" + "<td nowrap class=\"t_td\" align='center'>" + map.get("ptyp_d") + "</td>" + "<td nowrap class=\"t_td\" align='center'>" + map.get("pdat") + "</td>" + "<td nowrap class=\"t_td\" align='center'>" + map.get("stepdsca") + "</td>" + "</tr>" + "</table>" + "<table width='100%' border='1' class='table' cellpadding='0' cellspacing='0'>" + "<tr>" + "<td nowrap class=\"table_td_head\" align='center'>编号</td>" + "<td nowrap class=\"table_td_head\" align='center'>物料代码</td>" + "<td nowrap class=\"table_td_head\" align='center'>物料名称</td>" + "<td nowrap class=\"table_td_head\" align='center'>物料类别</td>" + "<td nowrap class=\"table_td_head\" align='center'>物料规格</td>" + "<td nowrap class=\"table_td_head\" align='center'>数量</td>" + "<td nowrap class=\"table_td_head\" align='center'>单位</td>" + "<td nowrap class=\"table_td_head\" align='center'>预算价</td>" + "<td nowrap class=\"table_td_head\" align='center'>品牌产地</td>" + "</tr>";
    String nama = "";String maso = "";String ctyp = "";String quan = "";String unit = "";String pri1 = "";String suno_dsca = "";String flag_ = "";
    String sta2 = "";
    for (Iterator iter = list.iterator(); iter.hasNext();)
    {
      Map row = (Map)iter.next();
      nama = row.get("nama") == null ? "" : row.get("nama").toString();
      maso = row.get("maso") == null ? "" : row.get("maso").toString();
      ctyp = row.get("ctyp") == null ? "" : row.get("ctyp").toString();
      quan = row.get("quan") == null ? "" : row.get("quan").toString();
      unit = row.get("unit") == null ? "" : row.get("unit").toString();
      pri1 = row.get("pri1") == null ? "" : row.get("pri1").toString();
      flag_ = row.get("flag") == null ? "" : row.get("flag").toString();
      suno_dsca = row.get("bpcd") == null ? "" : row.get("bpcd").toString();
      sta2 = row.get("sta2") == null ? "" : row.get("sta2").toString();
      
      result = result + "<tr>";
      if ("1".equals(sta2))
      {
        result = result + "<td nowrap class=\"t_td\" align='center'> <S>" + row.get("adid") + "</S></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'> <S>" + row.get("item") + "</td>";
        result = result + "<td nowrap class=\"t_td\" align='center'> <S>" + nama + "</S></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'> <S>" + ctyp + "</S></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'> <S>" + maso + "</S></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'> <S>" + quan + "</S></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'> <S>" + unit + "</S></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'> <S>" + pri1 + "</S></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'> <S>" + suno_dsca + "</S></td>";
        result = result + "</tr>";
      }
      else if ("1".equals(flag_))
      {
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + row.get("adid") + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + row.get("item") + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + nama + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + ctyp + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + maso + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + quan + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + unit + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + pri1 + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='orange'>" + suno_dsca + "</font></td>";
      }
      else if ("2".equals(flag_))
      {
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + row.get("adid") + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + row.get("item") + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + nama + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + ctyp + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + maso + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + quan + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + unit + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + pri1 + "</font></td>";
        result = result + "<td nowrap class=\"t_td\" align='center'><font color='red'>" + suno_dsca + "</font></td>";
      }
      else
      {
        result = result + "<td nowrap class=\"t_td\" align='center'>" + row.get("adid") + "</td>";
        result = result + "<td nowrap class=\"t_td\" align='center'>" + row.get("item") + "</td>";
        result = result + "<td nowrap class=\"t_td\" align='center'>" + nama + "</td>";
        result = result + "<td nowrap class=\"t_td\" align='center'>" + ctyp + "</td>";
        result = result + "<td nowrap class=\"t_td\" align='center'>" + maso + "</td>";
        result = result + "<td nowrap class=\"t_td\" align='center'>" + quan + "</td>";
        result = result + "<td nowrap class=\"t_td\" align='center'>" + unit + "</td>";
        result = result + "<td nowrap class=\"t_td\" align='center'>" + pri1 + "</td>";
        result = result + "<td nowrap class=\"t_td\" align='center'>" + suno_dsca + "</td>";
        result = result + "</tr>";
      }
    }
    result = result + "</table>";
    result = result + "<table>";
    result = result + "<tr>";
    result = result + "<td colSpan=9><FONT color=green>注：请及时<A HREF='http://10.1.18.83:8080/scc/index.html'>登录</A>系统处理。</FONT></td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td colSpan=9><B>注:</B></FONT>此邮件为系统信息,请不要作回复操作。</td>";
    result = result + "</tr>";
    result = result + "</table>";
    
    result = result + "</DIV></BODY></HTML>";
    System.out.println(result);
    return result;
  }*/
  
  private static String getContent1(String orno, Map row)
  {
    System.out.println("进入content");
    String result = "";
    result = "<HTML><HEAD><TITLE>非生产物料集中采购平台</TITLE><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><STYLE type=text/css>BODY {FONT-SIZE: 9pt; MARGIN: 0px; OVERFLOW: auto; FONT-FAMILY: Verdana, Geneva, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #ffffff}BODY {FONT-SIZE: 12px; COLOR: #0377C1; FONT-FAMILY: arial}TABLE {FONT-SIZE: 12px; COLOR: #0377C1; FONT-FAMILY: arial}DIV#default {BORDER-RIGHT: black 0px solid; PADDING-RIGHT: 10px; BORDER-TOP: black 0px solid; PADDING-LEFT: 10px; BACKGROUND: #fff; PADDING-BOTTOM: 20px; MARGIN: 10pt auto 20pt 20pt; BORDER-LEFT: black 0px solid; WIDTH: 700px; PADDING-TOP: 10px; BORDER-BOTTOM: black 0px solid; TEXT-ALIGN: left}</STYLE></HEAD><BODY><DIV id=default><B>非生产物料集中采购平台系统邮件提示:</B><BR><TABLE width=\"100%\">  <TBODY>  <TR>    <TD colSpan=2> <LI>您好，申购单号: <FONT color=red><U>" + 
    
      orno + 
      "</U></FONT> 的申请物料（部分）已到货。 <FONT color=blue>注：请在三天内开领料单领用</FONT></LI></TD></TR>";
    
    String adid = "";String anam = "";String item = "";String nama = "";String pri2 = "";String fta2 = "";String unit = "";String quan = "";String usid_d = "";String dat3 = "";String dat4 = "";String oper = "";String beiz = "";
    
    adid = row.get("adid") == null ? "" : row.get("adid").toString();
    item = row.get("item") == null ? "" : row.get("item").toString();
    nama = row.get("nama") == null ? "" : row.get("nama").toString();
    pri2 = row.get("pri2") == null ? "" : row.get("pri2").toString();
    fta2 = row.get("fta2").toString();
    quan = row.get("quan") == null ? "" : row.get("quan").toString();
    unit = row.get("unit") == null ? "" : row.get("unit").toString();
    usid_d = row.get("usid_d") == null ? "" : row.get("usid_d").toString();
    dat3 = row.get("dat3") == null ? "" : row.get("dat3").toString();
    dat4 = row.get("dat4") == null ? "" : row.get("dat4").toString();
    anam = row.get("anam") == null ? "" : row.get("anam").toString();
    beiz = row.get("beiz") == null ? "" : row.get("beiz").toString();
    oper = row.get("oper").toString();
    
    System.out.println("adid=" + adid + " item=" + item + " nama=" + nama + " pri2=" + pri2 + " fta2=" + fta2 + " quan=" + quan + " usid_d=" + usid_d + " dat3=" + dat3 + " dat4=" + dat4 + " oper=" + oper);
    
    result = result + "<tr><td align='left' width='30%'>";
    result = result + "<table width='100%' border='1' cellpadding='0' cellspacing='0'>";
    result = result + "<tr>";
    result = result + "<td align='left'>申购单序号：" + adid + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>物料代码：" + item + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>物料名称：" + nama + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>单价：" + pri2 + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>单位：" + unit + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>以旧换新：" + fta2 + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>申购数量：" + quan + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>申购者：" + anam + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>到货日期：" + dat3 + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>入库日期：" + dat4 + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>提交人：" + oper + "</td>";
    result = result + "</tr>";
    result = result + "<tr>";
    result = result + "<td align='left'>到货标识：<font color='red'>" + beiz + "</font></td>";
    result = result + "</tr>";
    result = result + "</table>";
    result = result + "</td>";
    result = result + "</tr>";
    
    result = result + "<TR><TD colSpan=2><LI><FONT color=red><B>注:</B></FONT> 此邮件为系统信息,请不要作回复操作。</LI></TD></TR></TBODY></TABLE></DIV></BODY></HTML>";
    
    System.out.println(result);
    return result;
  }
}
