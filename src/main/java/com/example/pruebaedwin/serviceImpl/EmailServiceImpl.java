package com.example.pruebaedwin.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.pruebaedwin.bean.ContactoBean;
import com.example.pruebaedwin.service.EmailService;

import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService{
	
	@Autowired
    private JavaMailSender emailSender;

	@Override
	public void enviarEmailContacto(ContactoBean contacto) throws Exception {
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		String html = "<!doctype html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
                "      xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Email</title>\n" +
                "</head>\n" +
//                "<body>\n" +
//                "<div>Welcome <b>" + "alanchumpitaz@gmail.com" + "</b></div>\n" +
//                "\n" +
//                "<div> Your username is <b>" + "alanchumpitaz@gmail.com" + "</b></div>\n" +
//                "</body>\n" +
                
            
                 "<body>\r\n"
                 + "   <div class=\"es-wrapper-color\">\r\n"
                 + "      <!--[if gte mso 9]>\r\n"
                 + "      <v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\r\n"
                 + "         <v:fill type=\"tile\" color=\"#f7f7f7\"></v:fill>\r\n"
                 + "      </v:background>\r\n"
                 + "      <![endif]--> \r\n"
                 + "      <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
                 + "         <tbody>\r\n"
                 + "            <tr>\r\n"
                 + "               <td class=\"esd-email-paddings ui-droppable\" valign=\"top\">\r\n"
                 + "                  <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content esd-header-popover ui-draggable\" align=\"center\">\r\n"
                 + "                     <tbody>\r\n"
                 + "                        <tr> \r\n"
                 + "                        </tr>\r\n"
                 + "                     </tbody>\r\n"
                 + "                  </table>\r\n"
                 + "                  <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header ui-draggable\" align=\"center\">\r\n"
                 + "                     <tbody>\r\n"
                 + "                        <tr>\r\n"
                 + "                           <td class=\"es-adaptive esd-stripe esd-frame esdev-disable-select esd-hover\" align=\"center\" esd-custom-block-id=\"88593\" esd-handler-name=\"stripeBlockHandler\">\r\n"
                 + "                              <div class=\"esd-structure-type\">\r\n"
                 + "                              </div>\r\n"
                 + "                              <table class=\"es-header-body\" style=\"background-color: rgb(61, 92, 163);\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#3d5ca3\" align=\"center\">\r\n"
                 + "                                 <tbody class=\"ui-droppable\">\r\n"
                 + "                                    <tr class=\"ui-draggable\">\r\n"
                 + "                                       <td class=\"esd-structure es-p20t es-p20b es-p20r es-p20l esd-frame esdev-disable-select esd-hover\" style=\"background-color: rgb(61, 92, 163);\" bgcolor=\"#3d5ca3\" align=\"left\" esd-handler-name=\"structureBlockHandler\">\r\n"
                 + "\r\n"
                 + "                                          <!--[if mso]>\r\n"
                 + "                                          <table width=\"560\" cellpadding=\"0\" \r\n"
                 + "                                             cellspacing=\"0\">\r\n"
                 + "                                             <tr>\r\n"
                 + "                                                <td width=\"270\" valign=\"top\">\r\n"
                 + "                                                   <![endif]--> \r\n"
                 + "                                                   <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n"
                 + "                                                      <tbody class=\"ui-droppable\">\r\n"
                 + "                                                         <tr class=\"ui-draggable\">\r\n"
                 + "                                                            <td class=\"es-m-p20b esd-container-frame esd-frame esd-hover esdev-disable-select\" width=\"270\" align=\"left\" esd-handler-name=\"containerHandler\">\r\n"
                 + "                                                               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
                 + "                                                                  <tbody class=\"ui-droppable\">\r\n"
                 + "                                                                     <tr class=\"ui-draggable\">\r\n"
                 + "                                                                        <td class=\"esd-block-image es-m-p0l es-m-txt-c esd-frame esd-hover esdev-disable-select esd-draggable esd-block\" align=\"left\" style=\"font-size:0\" esd-handler-name=\"imgBlockHandler\">\r\n"
                 + "                                                                           <div class=\"esd-block-btn \">\r\n"
                 + "                                                                           </div>\r\n"
                 + "                                                                        </td>\r\n"
                 + "                                                                     </tr>\r\n"
                 + "                                                                  </tbody>\r\n"
                 + "                                                               </table>\r\n"
                 + "                                                            </td>\r\n"
                 + "                                                         </tr>\r\n"
                 + "                                                      </tbody>\r\n"
                 + "                                                   </table>\r\n"
                 + "                                                   <!--[if mso]>\r\n"
                 + "                                                </td>\r\n"
                 + "                                                <td width=\"20\"></td>\r\n"
                 + "                                                <td width=\"270\" valign=\"top\">\r\n"
                 + "                                                   <![endif]--> \r\n"
                 + "\r\n"
                 + "                                                   <!--[if mso]>\r\n"
                 + "                                                </td>\r\n"
                 + "                                             </tr>\r\n"
                 + "                                          </table>\r\n"
                 + "                                          <![endif]-->\r\n"
                 + "                                       </td>\r\n"
                 + "                                    </tr>\r\n"
                 + "                                 </tbody>\r\n"
                 + "                              </table>\r\n"
                 + "                           </td>\r\n"
                 + "                        </tr>\r\n"
                 + "                     </tbody>\r\n"
                 + "                  </table>\r\n"
                 + "                  <table class=\"es-content ui-draggable\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n"
                 + "                     <tbody>\r\n"
                 + "                        <tr>\r\n"
                 + "                           <td class=\"esd-stripe esd-frame esdev-disable-select esd-hover\" align=\"center\" esd-handler-name=\"stripeBlockHandler\">\r\n"
                 + "\r\n"
                 + "                              <table class=\"es-content-body\" style=\"background-color: rgb(250, 250, 250);\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fafafa\" align=\"center\">\r\n"
                 + "                                 <tbody class=\"ui-droppable\">\r\n"
                 + "                                    <tr class=\"ui-draggable\">\r\n"
                 + "                                       <td class=\"esd-structure es-p20t es-p40b es-p20r es-p20l esd-frame esdev-disable-select esd-hover\" style=\"background-repeat: no-repeat;\" align=\"left\" esd-handler-name=\"structureBlockHandler\">\r\n"
                 + "\r\n"
                 + "                                          <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
                 + "                                             <tbody class=\"ui-droppable\">\r\n"
                 + "                                                <tr class=\"ui-draggable\">\r\n"
                 + "                                                   <td class=\"esd-container-frame esd-frame esd-hover esdev-disable-select\" width=\"560\" valign=\"top\" align=\"center\" esd-handler-name=\"containerHandler\">\r\n"
                 + "                                                      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
                 + "                                                         <tbody class=\"ui-droppable\">\r\n"
                 + "                                                            <tr class=\"ui-draggable\">\r\n"
                 + "                                                               <td class=\"esd-block-text es-p20t es-p10b esd-frame esd-hover esdev-disable-select esd-draggable esd-block\" align=\"center\" esd-handler-name=\"textElementHandler\">\r\n"
                 + "\r\n"
                 + "                                                                  <h1 style=\"color: #333333; font-family: lora, georgia, 'times new roman', serif; font-size: 50px;\"><em>Alimentos selectos</em></h1>\r\n"
                 + "                                                               </td>\r\n"
                 + "                                                            </tr>\r\n"
                 + "                                                            <tr class=\"ui-draggable\">\r\n"
                 + "                                                               <td class=\"esd-block-text es-p10t es-p10b esd-frame esd-hover esdev-disable-select esd-draggable esd-block\" align=\"center\" esd-handler-name=\"textElementHandler\">\r\n"
                 + "\r\n"
                 + "                                                                  <h3 style=\"color: #333333;\">Se envió un correo desde la web Alimentos Selectos.</h3>\r\n"
                 + "                                                               </td>\r\n"
                 + "                                                            </tr>\r\n"
                 + "                                                            <tr class=\"ui-draggable\">\r\n"
                 + "                                                               <td class=\"esd-block-text es-p20b esd-frame esd-hover esdev-disable-select esd-draggable esd-block\" align=\"left\" esd-handler-name=\"textElementHandler\">\r\n"
                 + "\r\n"
                 + "                                                                  <p>Nombre: "+contacto.getNombre()+"</p>\r\n"
                 + "                                                                  <p>Correo: "+contacto.getCorreo()+"</p>\r\n"
        		 + "                                                                  <p>Compañia: "+contacto.getCompania()+"</p>\r\n"
				 + "                                                                  <p>Tipo de compañia: "+contacto.getTipocompania()+"</p>\r\n"
				 + "                                                                  <p>Teléfono: "+contacto.getCelular()+"</p>\r\n"
				 + "                                                                  <p>Motivo: "+contacto.getMotivo()+"</p>\r\n"
                 + "                                                               </td>\r\n"
                 + "                                                            </tr>\r\n"
                 + "															<tr class=\"ui-draggable\">\r\n"
                 + "                                                               <td class=\"esd-block-text es-p20b esd-frame esd-hover esdev-disable-select esd-draggable esd-block\" align=\"left\" esd-handler-name=\"textElementHandler\">\r\n"

                 + "																  <h3 style=\"color: rgb(61, 92, 163);\">Mensaje:</h3>\r\n"
                 + "                                                                  <p>"+contacto.getMensaje()+"</p>\r\n"
                 + "                                                               </td>\r\n"
                 + "                                                            </tr>\r\n"
                 + "	\r\n"
                 + "                                                         </tbody>\r\n"
                 + "                                                      </table>\r\n"
                 + "                                                   </td>\r\n"
                 + "                                                </tr>\r\n"
                 + "                                             </tbody>\r\n"
                 + "                                          </table>\r\n"
                 + "                                       </td>\r\n"
                 + "                                    </tr>\r\n"
                 + "                                 </tbody>\r\n"
                 + "                              </table>\r\n"
                 + "                           </td>\r\n"
                 + "                        </tr>\r\n"
                 + "                     </tbody>\r\n"
                 + "                  </table>\r\n"
                 + "\r\n"
                 + "               </td>\r\n"
                 + "            </tr>\r\n"
                 + "         </tbody>\r\n"
                 + "      </table>\r\n"
                 + "   </div>\r\n"
                 + "</body>"+

                

                "</html>\n";
		
		helper.setFrom(contacto.getCorreo());
        helper.setTo("atencionalcliente@alimentoselectos.pe"); 
        helper.setSubject("Correo de contacto desde la web Alimentos Selectos"); 
        helper.setText(html,true);

        emailSender.send(mimeMessage);
		
	}
	
	@Override
	public void enviarEmailRespuestaContacto(ContactoBean contacto) throws Exception {
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		String html = "<!doctype html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
                "      xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Email</title>\n" +
                "</head>\n" +
//                "<body>\n" +
//                "<div>Welcome <b>" + "alanchumpitaz@gmail.com" + "</b></div>\n" +
//                "\n" +
//                "<div> Your username is <b>" + "alanchumpitaz@gmail.com" + "</b></div>\n" +
//                "</body>\n" +
                
            
                 "<body>\r\n"
                 + "   <div class=\"es-wrapper-color\">\r\n"
                 + "      <!--[if gte mso 9]>\r\n"
                 + "      <v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\r\n"
                 + "         <v:fill type=\"tile\" color=\"#f7f7f7\"></v:fill>\r\n"
                 + "      </v:background>\r\n"
                 + "      <![endif]--> \r\n"
                 + "      <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
                 + "         <tbody>\r\n"
                 + "            <tr>\r\n"
                 + "               <td class=\"esd-email-paddings ui-droppable\" valign=\"top\">\r\n"
                 + "                  <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content esd-header-popover ui-draggable\" align=\"center\">\r\n"
                 + "                     <tbody>\r\n"
                 + "                        <tr> \r\n"
                 + "                        </tr>\r\n"
                 + "                     </tbody>\r\n"
                 + "                  </table>\r\n"
                 + "                  <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header ui-draggable\" align=\"center\">\r\n"
                 + "                     <tbody>\r\n"
                 + "                        <tr>\r\n"
                 + "                           <td class=\"es-adaptive esd-stripe esd-frame esdev-disable-select esd-hover\" align=\"center\" esd-custom-block-id=\"88593\" esd-handler-name=\"stripeBlockHandler\">\r\n"
                 + "                              <div class=\"esd-structure-type\">\r\n"
                 + "                              </div>\r\n"
                 + "                              <table class=\"es-header-body\" style=\"background-color: rgb(61, 92, 163);\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#3d5ca3\" align=\"center\">\r\n"
                 + "                                 <tbody class=\"ui-droppable\">\r\n"
                 + "                                    <tr class=\"ui-draggable\">\r\n"
                 + "                                       <td class=\"esd-structure es-p20t es-p20b es-p20r es-p20l esd-frame esdev-disable-select esd-hover\" style=\"background-color: rgb(61, 92, 163);\" bgcolor=\"#3d5ca3\" align=\"left\" esd-handler-name=\"structureBlockHandler\">\r\n"
                 + "\r\n"
                 + "                                          <!--[if mso]>\r\n"
                 + "                                          <table width=\"560\" cellpadding=\"0\" \r\n"
                 + "                                             cellspacing=\"0\">\r\n"
                 + "                                             <tr>\r\n"
                 + "                                                <td width=\"270\" valign=\"top\">\r\n"
                 + "                                                   <![endif]--> \r\n"
                 + "                                                   <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n"
                 + "                                                      <tbody class=\"ui-droppable\">\r\n"
                 + "                                                         <tr class=\"ui-draggable\">\r\n"
                 + "                                                            <td class=\"es-m-p20b esd-container-frame esd-frame esd-hover esdev-disable-select\" width=\"270\" align=\"left\" esd-handler-name=\"containerHandler\">\r\n"
                 + "                                                               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
                 + "                                                                  <tbody class=\"ui-droppable\">\r\n"
                 + "                                                                     <tr class=\"ui-draggable\">\r\n"
                 + "                                                                        <td class=\"esd-block-image es-m-p0l es-m-txt-c esd-frame esd-hover esdev-disable-select esd-draggable esd-block\" align=\"left\" style=\"font-size:0\" esd-handler-name=\"imgBlockHandler\">\r\n"
                 + "                                                                           <div class=\"esd-block-btn \">\r\n"
                 + "                                                                           </div>\r\n"
                 + "                                                                        </td>\r\n"
                 + "                                                                     </tr>\r\n"
                 + "                                                                  </tbody>\r\n"
                 + "                                                               </table>\r\n"
                 + "                                                            </td>\r\n"
                 + "                                                         </tr>\r\n"
                 + "                                                      </tbody>\r\n"
                 + "                                                   </table>\r\n"
                 + "                                                   <!--[if mso]>\r\n"
                 + "                                                </td>\r\n"
                 + "                                                <td width=\"20\"></td>\r\n"
                 + "                                                <td width=\"270\" valign=\"top\">\r\n"
                 + "                                                   <![endif]--> \r\n"
                 + "\r\n"
                 + "                                                   <!--[if mso]>\r\n"
                 + "                                                </td>\r\n"
                 + "                                             </tr>\r\n"
                 + "                                          </table>\r\n"
                 + "                                          <![endif]-->\r\n"
                 + "                                       </td>\r\n"
                 + "                                    </tr>\r\n"
                 + "                                 </tbody>\r\n"
                 + "                              </table>\r\n"
                 + "                           </td>\r\n"
                 + "                        </tr>\r\n"
                 + "                     </tbody>\r\n"
                 + "                  </table>\r\n"
                 + "                  <table class=\"es-content ui-draggable\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n"
                 + "                     <tbody>\r\n"
                 + "                        <tr>\r\n"
                 + "                           <td class=\"esd-stripe esd-frame esdev-disable-select esd-hover\" align=\"center\" esd-handler-name=\"stripeBlockHandler\">\r\n"
                 + "\r\n"
                 + "                              <table class=\"es-content-body\" style=\"background-color: rgb(250, 250, 250);\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fafafa\" align=\"center\">\r\n"
                 + "                                 <tbody class=\"ui-droppable\">\r\n"
                 + "                                    <tr class=\"ui-draggable\">\r\n"
                 + "                                       <td class=\"esd-structure es-p20t es-p40b es-p20r es-p20l esd-frame esdev-disable-select esd-hover\" style=\"background-repeat: no-repeat;\" align=\"left\" esd-handler-name=\"structureBlockHandler\">\r\n"
                 + "\r\n"
                 + "                                          <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
                 + "                                             <tbody class=\"ui-droppable\">\r\n"
                 + "                                                <tr class=\"ui-draggable\">\r\n"
                 + "                                                   <td class=\"esd-container-frame esd-frame esd-hover esdev-disable-select\" width=\"560\" valign=\"top\" align=\"center\" esd-handler-name=\"containerHandler\">\r\n"
                 + "                                                      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
                 + "                                                         <tbody class=\"ui-droppable\">\r\n"
                 + "                                                            <tr class=\"ui-draggable\">\r\n"
                 + "                                                               <td class=\"esd-block-text es-p20t es-p10b esd-frame esd-hover esdev-disable-select esd-draggable esd-block\" align=\"center\" esd-handler-name=\"textElementHandler\">\r\n"
                 + "\r\n"
                 + "                                                                  <h1 style=\"color: #333333; font-family: lora, georgia, 'times new roman', serif; font-size: 50px;\"><em>Alimentos selectos</em></h1>\r\n"
                 + "                                                               </td>\r\n"
                 + "                                                            </tr>\r\n"
                 + "                                                            <tr class=\"ui-draggable\">\r\n"
                 + "                                                               <td class=\"esd-block-text es-p10t es-p10b esd-frame esd-hover esdev-disable-select esd-draggable esd-block\" align=\"center\" esd-handler-name=\"textElementHandler\">\r\n"
                 + "\r\n"
                 + "                                                                  <h3 style=\"color: #333333;\">Gracias por contactarnos "+contacto.getNombre()+".</h3>\r\n"
                 + "                                                               </td>\r\n"
                 + "                                                            </tr>\r\n"

                 + "															<tr class=\"ui-draggable\">\r\n"
                 + "                                                               <td class=\"esd-block-text es-p20b esd-frame esd-hover esdev-disable-select esd-draggable esd-block\" align=\"left\" esd-handler-name=\"textElementHandler\">\r\n"

                 + "																  <h3 style=\"color: rgb(61, 92, 163);\">En breve nos contactaremos contigo.</h3>\r\n"
                 + "                                                               </td>\r\n"
                 + "                                                            </tr>\r\n"
                 + "	\r\n"
                 + "                                                         </tbody>\r\n"
                 + "                                                      </table>\r\n"
                 + "                                                   </td>\r\n"
                 + "                                                </tr>\r\n"
                 + "                                             </tbody>\r\n"
                 + "                                          </table>\r\n"
                 + "                                       </td>\r\n"
                 + "                                    </tr>\r\n"
                 + "                                 </tbody>\r\n"
                 + "                              </table>\r\n"
                 + "                           </td>\r\n"
                 + "                        </tr>\r\n"
                 + "                     </tbody>\r\n"
                 + "                  </table>\r\n"
                 + "\r\n"
                 + "               </td>\r\n"
                 + "            </tr>\r\n"
                 + "         </tbody>\r\n"
                 + "      </table>\r\n"
                 + "   </div>\r\n"
                 + "</body>"+

                

                "</html>\n";
		
		helper.setFrom("atencionalcliente@alimentoselectos.pe");
        helper.setTo(contacto.getCorreo()); 
        helper.setSubject("Correo de contacto desde la web Alimentos Selectos"); 
        helper.setText(html,true);

        emailSender.send(mimeMessage);
		
	}

}
