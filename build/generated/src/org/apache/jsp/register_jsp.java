package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- beautify ignore:start -->\n");
      out.write("<html\n");
      out.write("    lang=\"en\"\n");
      out.write("    class=\"light-style customizer-hide\"\n");
      out.write("    dir=\"ltr\"\n");
      out.write("    data-theme=\"theme-default\"\n");
      out.write("    data-assets-path=\"../assets/\"\n");
      out.write("    data-template=\"vertical-menu-template-free\"\n");
      out.write("    >\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta\n");
      out.write("            name=\"viewport\"\n");
      out.write("            content=\"width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0\"\n");
      out.write("            />\n");
      out.write("\n");
      out.write("        <title>Đăng kí</title>\n");
      out.write("\n");
      out.write("        <meta name=\"description\" content=\"\" />\n");
      out.write("\n");
      out.write("        <!-- Favicon -->\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"../assets/img/favicon/favicon.ico\" />\n");
      out.write("\n");
      out.write("        <!-- Fonts -->\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\" />\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin />\n");
      out.write("        <link\n");
      out.write("            href=\"https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap\"\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            />\n");
      out.write("\n");
      out.write("        <!-- Icons. Uncomment required icon fonts -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendor/fonts/boxicons.css\" />\n");
      out.write("\n");
      out.write("        <!-- Core CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendor/css/core.css\" class=\"template-customizer-core-css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendor/css/theme-default.css\" class=\"template-customizer-theme-css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/demo.css\" />\n");
      out.write("\n");
      out.write("        <!-- Vendors CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css\" />\n");
      out.write("\n");
      out.write("        <!-- Page CSS -->\n");
      out.write("        <!-- Page -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendor/css/pages/page-auth.css\" />\n");
      out.write("        <!-- Helpers -->\n");
      out.write("        <script src=\"assets/vendor/js/helpers.js\"></script>\n");
      out.write("\n");
      out.write("        <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->\n");
      out.write("        <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->\n");
      out.write("        <script src=\"../assets/js/config.js\"></script>\n");
      out.write("        <script type = \"text/javascript\">\n");
      out.write("            function check() {\n");
      out.write("                var pass1 = document.reform.password.value;\n");
      out.write("                var pass2 = document.reform.repassword.value;\n");
      out.write("                if (pass1 == pass2) {\n");
      out.write("                    if (pass1 < 6)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"errorpass\").innerHTML = \"Độ dài mật khẩu ít nhất 6 kí tự\";\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"errortrung\").innerHTML = \"Mật khẩu không khớp\";\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- Content -->\n");
      out.write("\n");
      out.write("        <div class=\"container-xxl\">\n");
      out.write("            <div class=\"authentication-wrapper authentication-basic container-p-y\">\n");
      out.write("                <div class=\"authentication-inner\">\n");
      out.write("                    <!-- Register Card -->\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <!-- Logo -->\n");
      out.write("                            <div class=\"app-brand justify-content-center\">\n");
      out.write("                                <a href=\"home\" class=\"app-brand-link gap-2\">\n");
      out.write("                                    <span class=\"app-brand-logo demo\">\n");
      out.write("                                        <svg\n");
      out.write("                                            width=\"25\"\n");
      out.write("                                            viewBox=\"0 0 25 42\"\n");
      out.write("                                            version=\"1.1\"\n");
      out.write("                                            xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                            xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n");
      out.write("                                            >\n");
      out.write("                                        <defs>\n");
      out.write("                                        <path\n");
      out.write("                                            d=\"M13.7918663,0.358365126 L3.39788168,7.44174259 C0.566865006,9.69408886 -0.379795268,12.4788597 0.557900856,15.7960551 C0.68998853,16.2305145 1.09562888,17.7872135 3.12357076,19.2293357 C3.8146334,19.7207684 5.32369333,20.3834223 7.65075054,21.2172976 L7.59773219,21.2525164 L2.63468769,24.5493413 C0.445452254,26.3002124 0.0884951797,28.5083815 1.56381646,31.1738486 C2.83770406,32.8170431 5.20850219,33.2640127 7.09180128,32.5391577 C8.347334,32.0559211 11.4559176,30.0011079 16.4175519,26.3747182 C18.0338572,24.4997857 18.6973423,22.4544883 18.4080071,20.2388261 C17.963753,17.5346866 16.1776345,15.5799961 13.0496516,14.3747546 L10.9194936,13.4715819 L18.6192054,7.984237 L13.7918663,0.358365126 Z\"\n");
      out.write("                                            id=\"path-1\"\n");
      out.write("                                            ></path>\n");
      out.write("                                        <path\n");
      out.write("                                            d=\"M5.47320593,6.00457225 C4.05321814,8.216144 4.36334763,10.0722806 6.40359441,11.5729822 C8.61520715,12.571656 10.0999176,13.2171421 10.8577257,13.5094407 L15.5088241,14.433041 L18.6192054,7.984237 C15.5364148,3.11535317 13.9273018,0.573395879 13.7918663,0.358365126 C13.5790555,0.511491653 10.8061687,2.3935607 5.47320593,6.00457225 Z\"\n");
      out.write("                                            id=\"path-3\"\n");
      out.write("                                            ></path>\n");
      out.write("                                        <path\n");
      out.write("                                            d=\"M7.50063644,21.2294429 L12.3234468,23.3159332 C14.1688022,24.7579751 14.397098,26.4880487 13.008334,28.506154 C11.6195701,30.5242593 10.3099883,31.790241 9.07958868,32.3040991 C5.78142938,33.4346997 4.13234973,34 4.13234973,34 C4.13234973,34 2.75489982,33.0538207 2.37032616e-14,31.1614621 C-0.55822714,27.8186216 -0.55822714,26.0572515 -4.05231404e-15,25.8773518 C0.83734071,25.6075023 2.77988457,22.8248993 3.3049379,22.52991 C3.65497346,22.3332504 5.05353963,21.8997614 7.50063644,21.2294429 Z\"\n");
      out.write("                                            id=\"path-4\"\n");
      out.write("                                            ></path>\n");
      out.write("                                        <path\n");
      out.write("                                            d=\"M20.6,7.13333333 L25.6,13.8 C26.2627417,14.6836556 26.0836556,15.9372583 25.2,16.6 C24.8538077,16.8596443 24.4327404,17 24,17 L14,17 C12.8954305,17 12,16.1045695 12,15 C12,14.5672596 12.1403557,14.1461923 12.4,13.8 L17.4,7.13333333 C18.0627417,6.24967773 19.3163444,6.07059163 20.2,6.73333333 C20.3516113,6.84704183 20.4862915,6.981722 20.6,7.13333333 Z\"\n");
      out.write("                                            id=\"path-5\"\n");
      out.write("                                            ></path>\n");
      out.write("                                        </defs>\n");
      out.write("                                        <g id=\"g-app-brand\" stroke=\"none\" stroke-width=\"1\" fill=\"none\" fill-rule=\"evenodd\">\n");
      out.write("                                        <g id=\"Brand-Logo\" transform=\"translate(-27.000000, -15.000000)\">\n");
      out.write("                                        <g id=\"Icon\" transform=\"translate(27.000000, 15.000000)\">\n");
      out.write("                                        <g id=\"Mask\" transform=\"translate(0.000000, 8.000000)\">\n");
      out.write("                                        <mask id=\"mask-2\" fill=\"white\">\n");
      out.write("                                            <use xlink:href=\"#path-1\"></use>\n");
      out.write("                                        </mask>\n");
      out.write("                                        <use fill=\"#696cff\" xlink:href=\"#path-1\"></use>\n");
      out.write("                                        <g id=\"Path-3\" mask=\"url(#mask-2)\">\n");
      out.write("                                        <use fill=\"#696cff\" xlink:href=\"#path-3\"></use>\n");
      out.write("                                        <use fill-opacity=\"0.2\" fill=\"#FFFFFF\" xlink:href=\"#path-3\"></use>\n");
      out.write("                                        </g>\n");
      out.write("                                        <g id=\"Path-4\" mask=\"url(#mask-2)\">\n");
      out.write("                                        <use fill=\"#696cff\" xlink:href=\"#path-4\"></use>\n");
      out.write("                                        <use fill-opacity=\"0.2\" fill=\"#FFFFFF\" xlink:href=\"#path-4\"></use>\n");
      out.write("                                        </g>\n");
      out.write("                                        </g>\n");
      out.write("                                        <g\n");
      out.write("                                            id=\"Triangle\"\n");
      out.write("                                            transform=\"translate(19.000000, 11.000000) rotate(-300.000000) translate(-19.000000, -11.000000) \"\n");
      out.write("                                            >\n");
      out.write("                                        <use fill=\"#696cff\" xlink:href=\"#path-5\"></use>\n");
      out.write("                                        <use fill-opacity=\"0.2\" fill=\"#FFFFFF\" xlink:href=\"#path-5\"></use>\n");
      out.write("                                        </g>\n");
      out.write("                                        </g>\n");
      out.write("                                        </g>\n");
      out.write("                                        </g>\n");
      out.write("                                        </svg>\n");
      out.write("                                    </span>\n");
      out.write("                                    <span class=\"app-brand-text demo text-body fw-bolder\">food order</span>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /Logo -->\n");
      out.write("                            <h4 class=\"mb-2\">Adventure starts here 🚀</h4>\n");
      out.write("                            <p class=\"mb-4\">Make your app management easy and fun!</p>\n");
      out.write("\n");
      out.write("                            <form id=\"formAuthentication\" class=\"mb-3\" action=\"index.html\" method=\"POST\">\n");
      out.write("                                <div class=\"mb-3\">\n");
      out.write("                                    <label for=\"fullname\" class=\"form-label\">Họ và tên</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"fullname\" name=\"fullname\" placeholder=\"Nhập họ và tên của bạn\" />\n");
      out.write("                                </div>\n");
      out.write("                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                <div class=\"mb-3\">\n");
      out.write("                                    <label for=\"username\" class=\"form-label\">Tên đăng nhập</label>\n");
      out.write("                                    <input\n");
      out.write("                                        type=\"text\"\n");
      out.write("                                        class=\"form-control\"\n");
      out.write("                                        id=\"username\"\n");
      out.write("                                        name=\"username\"\n");
      out.write("                                        placeholder=\"Nhập tên đăng nhập của bạn\"\n");
      out.write("                                        autofocus\n");
      out.write("                                        />\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"mb-3\">\n");
      out.write("                                    <label for=\"email\" class=\"form-label\">Email</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Nhập email\" />\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mb-3 form-password-toggle\">\n");
      out.write("                                    <label class=\"form-label\" for=\"password\">Mật khẩu</label>\n");
      out.write("                                    <div class=\"input-group input-group-merge\">\n");
      out.write("                                        <input\n");
      out.write("                                            type=\"password\"\n");
      out.write("                                            id=\"password\"\n");
      out.write("                                            class=\"form-control\"\n");
      out.write("                                            name=\"password\"\n");
      out.write("                                            placeholder=\"&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;\"\n");
      out.write("                                            aria-describedby=\"password\"\n");
      out.write("                                            />\n");
      out.write("                                        <span class=\"input-group-text cursor-pointer\"><i class=\"bx bx-hide\"></i></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mb-3\">\n");
      out.write("                                    <label for=\"gender\" class=\"form-label\">Giới tính</label>\n");
      out.write("                                    <select>\n");
      out.write("                                        <option value = \"0\">Nam</option>\n");
      out.write("                                        <option value = \"1\">Nữ</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mb-3\">\n");
      out.write("                                    <div class=\"form-check\">\n");
      out.write("                                        <input class=\"form-check-input\" type=\"checkbox\" id=\"terms-conditions\" name=\"terms\" />\n");
      out.write("                                        <label class=\"form-check-label\" for=\"terms-conditions\">\n");
      out.write("                                            I agree to\n");
      out.write("                                            <a href=\"javascript:void(0);\">privacy policy & terms</a>\n");
      out.write("                                        </label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <button class=\"btn btn-primary d-grid w-100\">Đăng kí</button>\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                            <p class=\"text-center\">\n");
      out.write("                                <span>Bạn đã có tài khoản?</span>\n");
      out.write("                                <a href=\"login\">\n");
      out.write("                                    <span>Đăng nhập</span>\n");
      out.write("                                </a>\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Register Card -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- / Content -->\n");
      out.write("\n");
      out.write("        <!-- Core JS -->\n");
      out.write("        <!-- build:js assets/vendor/js/core.js -->\n");
      out.write("        <script src=\"assets/vendor/libs/jquery/jquery.js\"></script>\n");
      out.write("        <script src=\"assets/vendor/libs/popper/popper.js\"></script>\n");
      out.write("        <script src=\"assets/vendor/js/bootstrap.js\"></script>\n");
      out.write("        <script src=\"assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"assets/vendor/js/menu.js\"></script>\n");
      out.write("        <!-- endbuild -->\n");
      out.write("\n");
      out.write("        <!-- Vendors JS -->\n");
      out.write("\n");
      out.write("        <!-- Main JS -->\n");
      out.write("        <script src=\"assets/js/main.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Page JS -->\n");
      out.write("\n");
      out.write("        <!-- Place this tag in your head or just before your close body tag. -->\n");
      out.write("        <script async defer src=\"https://buttons.github.io/buttons.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${res!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <label for=\"username\" class=\"form-label\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${res}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</label>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
