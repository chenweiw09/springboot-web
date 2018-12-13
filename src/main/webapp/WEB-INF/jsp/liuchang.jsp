<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html >
  <head>
    <title>Liu chang &mdash; My Personal/CV Website</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    
    <!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="/static/css/animate.css">
    <link rel="stylesheet" href="/static/css/flexslider.css">
    <link rel="stylesheet" href="/static/fonts/icomoon/style.css">

    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/css/style.css">

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700" rel="stylesheet">

    
  </head>
  <body data-spy="scroll" data-target="#pb-navbar" data-offset="200">

   
    <nav class="navbar navbar-expand-lg site-navbar navbar-light bg-light" id="pb-navbar">

      <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <a class="navbar-brand" href="<%=request.getContextPath() %>/index">关于我</a>
        <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample09">
          <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="#section-home">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="#section-about">About</a></li>
            <li class="nav-item"><a class="nav-link" href="#section-resume">Resume</a></li>
            <li class="nav-item"><a class="nav-link" href="#section-contact">Contact</a></li>
          </ul>
        </div>
      </div>
    </nav>
    

   
    
    <section class="site-hero" id="section-home" data-stellar-background-ratio="0.5">
      <div class="container">
        <div class="row intro-text align-items-center justify-content-center">
          <div class="col-md-10 text-center">
            <h1 class="site-heading site-animate">Howdy, I'm <strong>Liu Chang</strong></h1>
            <p class="lead site-subheading mb-4 site-animate">
              A graduating Ph.D. researching in biological cell engineering. Now she is seeking a junior high school teacher job. Becoming a university would be better.
              </p>
            <p><a href="#section-about" class="smoothscroll btn btn-primary px-4 py-3">More On Me</a></p>
          </div>
        </div>
      </div>
    </section> <!-- section -->

  
    <section class="site-section" id="section-about">
      <div class="container">
        <div class="row mb-5 align-items-center">
          <div class="col-lg-7 pr-lg-5 mb-5 mb-lg-0">
            <img src="/static/images/image_1_long.jpg" alt="Image placeholder" class="img-fluid">
          </div>
          <div class="col-lg-5 pl-lg-5">
            <div class="section-heading">
              <h2>About <strong>Me</strong></h2>
            </div>
            <p class="lead">请开始你的表演吧，这样就能填充一些内容了</p>
            <p class="mb-5  ">A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>

            <p>
              <a href="#section-contact" class="btn btn-primary px-4 py-2 btn-sm smoothscroll">Hire Me</a>
              <a href="<%=request.getContextPath()%>/resume/liuchang/myresume" class="btn btn-secondary px-4 py-2 btn-sm">下载简历</a>
            </p>
          </div>
        </div>

        <div class="row pt-5">
          <div class="col-md-3 mb-3">
            <div class="section-heading">
              <h2>My <strong>Skills</strong></h2>
            </div>
          </div>
          <div class="col-md-9">
            <div class="skill">
              <h3>细胞生物专业知识</h3>
              <div class="progress">
                <div class="progress-bar" role="progressbar" style="width: 85%" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100">
                  <span>85%</span>
                </div>
              </div>
            </div>

            <div class="skill">
              <h3>显微镜使用</h3>
              <div class="progress">
                <div class="progress-bar" role="progressbar" style="width: 98%" aria-valuenow="98" aria-valuemin="0" aria-valuemax="100">
                  <span>98%</span>
                </div>
              </div>
            </div>

            <div class="skill">
              <h3>研究</h3>
              <div class="progress">
                <div class="progress-bar" role="progressbar" style="width: 97%" aria-valuenow="97" aria-valuemin="0" aria-valuemax="100">
                  <span>97%</span>
                </div>
              </div>
            </div>

            <div class="skill">
              <h3>英文阅读能力</h3>
              <div class="progress">
                <div class="progress-bar" role="progressbar" style="width: 88%" aria-valuenow="88" aria-valuemin="0" aria-valuemax="100">
                  <span>88%</span>
                </div>
              </div>
            </div>

            <div class="skill">
              <h3>实验能力</h3>
              <div class="progress">
                <div class="progress-bar" role="progressbar" style="width: 92%" aria-valuenow="92" aria-valuemin="0" aria-valuemax="100">
                  <span>92%</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="site-section bg-light " id="section-resume">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-5">
            <div class="section-heading text-center">
              <h2>My <strong>Resume</strong></h2>
            </div>
          </div>
          <div class="col-md-6">
            <h2 class="mb-5">Education</h2>
            <div class="resume-item mb-4">
              <span class="date"><span class="icon-calendar"></span> 2014/09 - 现在</span>
              <h3>细胞生命科学 博士研究生</h3>
              <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              <span class="school">北京师范大学</span>
            </div>

            <div class="resume-item mb-4">
              <span class="date"><span class="icon-calendar"></span> 2012/09 - 2014/06.</span>
              <h3>细胞生物 硕士研究生</h3>
              <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              <span class="school">北京师范大学</span>
            </div>

            <div class="resume-item mb-4">
              <span class="date"><span class="icon-calendar"></span> 2009/09 - 2012/06</span>
              <h3>生物 学士</h3>
              <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              <span class="school">辽宁师范大学</span>
            </div>


          </div>
          <div class="col-md-6">
            

            <h2 class="mb-5">实习经历</h2>

            <div class="resume-item mb-4">
              <span class="date"><span class="icon-calendar"></span> March 2013 - Present</span>
              <h3>Lead Product Designer</h3>
              <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              <span class="school">xxx</span>
            </div>

            <div class="resume-item mb-4">
              <span class="date"><span class="icon-calendar"></span> March 2013 - Present</span>
              <h3>Lead Product Designer</h3>
              <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              <span class="school">Facebook</span>
            </div>

            <div class="resume-item mb-4">
              <span class="date"><span class="icon-calendar"></span> March 2013 - Present</span>
              <h3>Lead Product Designer</h3>
              <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              <span class="school">Twitter</span>
            </div>

            <div class="resume-item mb-4">
              <span class="date"><span class="icon-calendar"></span> March 2013 - Present</span>
              <h3>Lead Product Designer</h3>
              <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              <span class="school">Shopify</span>
            </div>


          </div>
        </div>
      </div>
    </section> <!-- .section -->

    <section class="site-section bg-light" id="section-contact">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-5">
            <div class="section-heading text-center">
              <h2>Wanna <strong>Start Work</strong> With Me?</h2>
            </div>
          </div>
          
          <div class="col-md-7 mb-5 mb-md-0">
            <form action="" class="site-form">
              <h3 class="mb-5">保持联系</h3>
              <div class="form-group">
                <input type="text" class="form-control px-3 py-4" placeholder="Your Name">
              </div>
              <div class="form-group">
                <input type="email" class="form-control px-3 py-4" placeholder="Your Email">
              </div>
              <div class="form-group">
                <input type="email" class="form-control px-3 py-4" placeholder="Your Phone">
              </div>
              <div class="form-group mb-5">
                <textarea class="form-control px-3 py-4"cols="30" rows="10" placeholder="Write a Message"></textarea>
              </div>
              <div class="form-group">
                <input type="submit" class="btn btn-primary  px-4 py-3" value="Send Message">
              </div>
            </form>
          </div>
          <div class="col-md-5 pl-md-5">
            <h3 class="mb-5">我的联系方式</h3>
            <ul class="site-contact-details">
              <li>
                <span class="text-uppercase">邮箱</span>
                site@gmail.com
              </li>
              <li>
                <span class="text-uppercase">电话</span>
                +30 976 1382 9921
              </li>
              <li>
                <span class="text-uppercase">微信</span>
                +30 976 1382 9922
              </li>
              <li>
                <span class="text-uppercase">联系地址</span>
                北京师范大学 科技楼 <br>
                北太平庄 19号  <br>
                北京 北京市海淀区
              </li>
            </ul>
          </div>
        </div>
      </div>
    </section>


    <footer class="site-footer">
      <div class="container">
        <div class="row mb-3">
          <div class="col-md-12 text-center">
            <p>
              <a href="#" class="social-item"><span class="icon-facebook2"></span></a>
              <a href="#" class="social-item"><span class="icon-twitter"></span></a>
              <%--<a href="#" class="social-item"><span class="icon-instagram2"></span></a>--%>
              <%--<a href="#" class="social-item"><span class="icon-linkedin2"></span></a>--%>
              <%--<a href="#" class="social-item"><span class="icon-vimeo"></span></a>--%>
            </p>
          </div>
        </div>
        <div class="row">
            <p class="col-12 text-center">
            
            Copyright &copy; <script>document.write(new Date().getFullYear());</script> - Colorlib All rights reserved | More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
            
            </p>
        </div>
      </div>
    </footer>

    
    

    <script src="/static/js/vendor/jquery.min.js"></script>
    <script src="/static/js/vendor/popper.min.js"></script>
    <script src="/static/js/vendor/bootstrap.min.js"></script>
    
    <script src="/static/js/vendor/jquery.easing.1.3.js"></script>
    <script src="/static/js/vendor/jquery.stellar.min.js"></script>
    <script src="/static/js/vendor/jquery.waypoints.min.js"></script>

    <script src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.min.js"></script>
    <script src="https://unpkg.com/imagesloaded@4/imagesloaded.pkgd.min.js"></script>
    <script src="/static/js/custom.js"></script>


  </body>
</html>