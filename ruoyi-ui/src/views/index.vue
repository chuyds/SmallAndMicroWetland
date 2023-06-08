<template>
  <div id="index">

    <div class="grid-content bg-purple-dark">
      <!-- 最外层div -->
      <div id="slide" class="outest" @mouseover="mouseEnter = true" @mouseleave="mouseEnter = false" >
        <!-- 向左img -->
        <img class="icon _left" src="../img/左箭头.png" alt="向左" v-show="mouseEnter" @click="gotoLast()"/>
        <!-- 主要图片 -->
        <ul id="imgsList" ref="myul">
          <li v-for="e of pictures" :key="e.index" :ref="e.ref">
            <img :src="e.src" :alt="e.alt" />
          </li>
        </ul>
        <!-- 底部小圆圈的设置 -->
        <div class="mydiv" v-show="mouseEnter">
          <div class="empty-cicle" v-for="e of pictures" :key="e.index" ref="cicle" @click="gotoDirectly(e.index)" ></div>
        </div>
        <!-- 向右div -->
        <img class="icon _right" src="../img/右箭头.png" alt="向右" v-show="mouseEnter" @click="gotoNext()"/>
      </div>
    </div>

    <main>
      <!-- organic food section -->
      <section class="about-section">

      <el-row :gutter="20">

              <el-col :span="12">
                <el-card style="height: 650px">
                    <div slot="header" class="clearfix">
                       <h6><span>智慧农业设备分布与状态</span></h6>
                     </div>
                     <iframe id="map" src="map.html" width="100%" frameborder="0" scrolling="no"></iframe>
                </el-card>
              </el-col>

              <el-col :span="12">
                <el-card style="height: 650px">
                    <h6><span>智慧农业环境数据</span></h6>

                    <el-row :gutter="350" style="margin-top: 10px;">
                      <el-col :span="6">
                        <el-card style="height: 70px; width: 300px; margin-top: 15px;">
                          <img src="./static/image/t1.png" class="tt"><span style="padding-left: 10px;">空气温度   36°</span>
                        </el-card>

                        <el-card style="height: 70px; width: 300px; margin-top: 15px;">
                          <img src="./static/image/t3.png" class="tt"><span style="padding-left: 10px;">光照强度   100000Lux</span>
                        </el-card>

                        <el-card style="height: 70px; width: 300px; margin-top: 15px;">
                          <img src="./static/image/t5.png" class="tt"><span style="padding-left: 10px;">H2S浓度   0.0001ppm</span>
                        </el-card>

                        </el-col>


                        <el-col :span="6">
                        <el-card style="height: 70px; width: 300px; margin-top: 15px;">
                          <img src="./static/image/t2.png" class="tt"><span style="padding-left: 10px;">空气湿度   32</span>
                        </el-card>

                        <el-card style="height: 70px; width: 300px; margin-top: 15px;">
                          <img src="./static/image/t4.png" class="tt"><span style="padding-left: 10px;">CO2浓度   0.04%</span>
                        </el-card>

                        <el-card style="height: 70px; width: 300px; margin-top: 15px;">
                          <img src="./static/image/t6.png" class="tt"><span style="padding-left: 10px;">NH3浓度   0.0001%</span>
                        </el-card>
                      </el-col>


                    </el-row>

                    <el-row>
                      <el-col :span="12">
                        <div class="weather">
                            <div id="he-plugin-standard"></div>
                        </div>
                      </el-col>
                    </el-row>

                </el-card>
              </el-col>

        </el-row>

      </section>
        <!-- end food section -->

      <iframe id="sliderLink" src="slider.html" width="100%" scrolling="no"></iframe>

        <!-- service section -->
        <section class="service-section">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="base-header">
                            <small>智慧数字农业</small>
                            <h3>智能化云平台</h3>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 col-sm-12">
                        <div class="service-item">
                            <div class="img_serv">
                                <a href="service-page.html">
                                    <img src="./static/image/s1.jpg" alt="service">
                                </a>
                            </div>
                            <div class="service_text">
                                <a href="service-page.html">
                                    <h4>智慧感知为农业赋能</h4>
                                </a>
                                <p>利用现代技术手段，如物联网、人工智能等，对农业生产过程中的土壤、气象、
                                植物等进行监测和数据分析，实现精准农业、智慧农业的生产方式。智慧农业监控系统包括了物联网终端设备与
                                图像识别模型，实现农业现场采集数据的显示、控制操作等</p>
                            </div>
                            <a class="serv_link" href="service-page.html"><i class="icon-glyph-40"></i></a>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-12">
                        <div class="service-item">
                            <div class="img_serv">
                                <a href="service-page.html">
                                    <img src="./static/image/s2.jpg" alt="service">
                                </a>
                            </div>
                            <div class="service_text">
                                <a href="service-page.html">
                                    <h4>智慧农业监控平台</h4>
                                </a>
                                <p>智慧农业监控平台应用物联网技术,对农业温室大棚环境等进行全面感知，可通过手机、平板、计算机实时获取温室大棚内部的空气温湿度、
                                二氧化碳浓度、光照强度等信息，在云业务管理平台上，实时监测温室大棚内环境参数的变化和农业作物培育、种植、生长状况等</p>
                            </div>
                            <a class="serv_link" href="service-page.html"><i class="icon-glyph-40"></i></a>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-12">
                        <div class="service-item">
                            <div class="img_serv">
                                <a href="service-page.html">
                                    <img src="./static/image/s3.jpg" alt="" srcset="">
                                </a>
                            </div>
                            <div class="service_text">
                                <a href="service-page.html">
                                    <h4>全方位物联网改造</h4>
                                </a>
                                <p>通过利用物联网技术与Web服务对农业生产环节中涉及到的各种农业相关信息方面进行智能监测和数据分析，从而实现对农业全产业链的实时追踪和管理。这一方法可以提高农业生产效益，减少资源浪费，促进农业可持续发展。</p>
                            </div>
                            <a class="serv_link" href="service-page.html"><i class="icon-glyph-40"></i></a>
                        </div>
                    </div>
                </div>
            </div>

            <br><br><br>

            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="base-header">
                            <small>安徽省文化产业</small>
                            <h3>徽 + 产业</h3>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 col-sm-12">
                        <div class="service-item">
                            <div class="img_serv">
                                <a href="service-page.html">
                                    <img src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.alicdn.com%2Fbao%2Fuploaded%2Fi1%2F2890305967%2FTB2CBBBb6gy_uJjSZKbXXXXkXXa_%21%210-paimai.jpg&refer=http%3A%2F%2Fimg.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1686638364&t=30f032bc55c771fc142b2ea3ff9def05" alt="service">
                                </a>
                            </div>
                            <div class="service_text">
                                <a href="service-page.html">
                                    <h4>徽 + 酒</h4>
                                </a>
                                <p>古井贡酒产自安徽省亳州市，属于大曲浓香型白酒，有“酒中牡丹”之称、被称为中国八大名酒之一。其渊源
                                始于建安元年（196年）曹操将家乡亳州产的“九酝春酒”和酿造方法进献给汉献帝刘协。具有“色清如水晶，
                                香醇如幽兰，入口甘美醇和，回昧经久不息”的特点。以安徽淮北平原优质小麦、古井镇优质地下水以及颗粒饱满、
                                糯性强的优质高梁为原料，利用其自然微生物环境，按古井贡酒传统工艺生产而成。</p>
                            </div>
                            <a class="serv_link" href="service-page.html"><i class="icon-glyph-40"></i></a>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-12">
                        <div class="service-item">
                            <div class="img_serv">
                                <a href="service-page.html">
                                    <img src="https://dili.chazidian.com/uploadfile/dili/baike/2017/05/24/4055690084.jpg" alt="service">
                                </a>
                            </div>
                            <div class="service_text">
                                <a href="service-page.html">
                                    <h4>徽 + 山</h4>
                                </a>
                                <p>黄山，古称黟山，位于安徽省黄山市境内，是中华十大名山之一、世界文化与自然遗产。东起黄狮岭，西至小岭脚，
                                北始二龙桥，南达汤口镇，山境南北长约40千米，东西宽约30千米，总占地面积约1200平方千米，属亚热带季风气候，由于山高谷深，气候呈垂直变化；
                                以奇松、怪石、云海、温泉、冬雪“五绝”及历史遗存、书画、文学、传说、名人“五胜”著称于世，有“天下第一奇山”、
                                “天开图画”、“松海云川”之称。</p>
                            </div>
                            <a class="serv_link" href="service-page.html"><i class="icon-glyph-40"></i></a>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-12">
                        <div class="service-item">
                            <div class="img_serv">
                                <a href="service-page.html">
                                    <img src="https://img1.baidu.com/it/u=64830204,4271128327&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=400" alt="service">
                                </a>
                            </div>
                            <div class="service_text">
                                <a href="service-page.html">
                                    <h4>徽 + 茶</h4>
                                </a>
                                <p>安徽盛产茶叶，中国十大名茶之中，安徽茶叶占三成。其中的黄山毛峰产于安徽省黄山（徽州）一带，所以又称徽茶，
                                由清代光绪年间谢裕大茶庄所创制。每年清明谷雨，选摘良种茶树“黄山种”、“黄山大叶种”等的初展肥壮嫩芽，手工炒制，
                                该茶外形微卷，状似雀舌，绿中泛黄，银毫显露，且带有金黄色鱼叶（俗称黄金片）。入杯冲泡雾气结顶，汤色清碧微黄，
                                叶底黄绿有活力，滋味醇甘，香气如兰，韵味深长。</p>
                            </div>
                            <a class="serv_link" href="service-page.html"><i class="icon-glyph-40"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end service section -->

        <br><br><br>
        <!-- whychose section -->
        <section class="whychose-section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5 col-sm-12">
                        <div class="whychose_bg"></div>
                    </div>
                    <div class="col-lg-7 col-sm-12">
                        <div class="whychose_wrapper">
                            <div class=" white_header_left">
                                <small>What We Do</small>
                                <h3>Why Choose Us</h3>
                            </div>
                            <div class="special_ser_item">
                                <div class="special_ser_icon"><i class="icon-glyph-20"></i></div>
                                <h4>高品质</h4>
                                <p>我们深知只有不断提高产品质量和技术含量，才能提升企业的核心竞争优势，才能发展建立更多高素质、
                                高要求的优质客户群体。登高才能望远，质量是维护顾客忠诚的最好保证。</p>
                            </div>
                            <div class="special_ser_item">
                                <div class="special_ser_icon"><i class="icon-glyph-13"></i></div>
                                <h4>低价格</h4>
                                <p>一样的物品，一半的价钱！</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end whychose section -->

        <!-- team section -->
        <section class="team-section">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="base-header">
                            <small>企业云集</small>
                            <h3>知名企业家</h3>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 col-sm-12">
                        <div class="team-box">
                            <div class="team_img">
                                <img src="../../public/static/picture/head_logo1.png" alt="">
                            </div>
                            <div class="team_info">
                                <h4>尹同跃</h4>
                                <p>奇瑞汽车董事长</p>
<!--                                <ul class="team_social">
                                    <li><a href="javascript:void(0)"><i class="bi bi-facebook"></i></a>
                                    </li>
                                    <li><a href="javascript:void(0)"><i class="bi bi-twitter"></i></a>
                                    </li>
                                    <li><a href="javascript:void(0)"><i class="bi bi-linkedin"></i></a>
                                    </li>
                                </ul> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-12">
                        <div class="team-box">
                            <div class="team_img">
                                <img src="../../public/static/picture/head_logo2.png" alt="">
                            </div>
                            <div class="team_info">
                                <h4>李斌</h4>
                                <p>蔚来汽车董事长兼CEO</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-12">
                        <div class="team-box">
                            <div class="team_img">
                                <img src="../../public/static/picture/head_logo3.png" alt="">
                            </div>
                            <div class="team_info">
                                <h4>梁金辉</h4>
                                <p>古井集团董事长</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-12">
                        <div class="team-box">
                            <div class="team_img">
                                <img src="../../public/static/picture/head_logo2.png" alt="">
                            </div>
                            <div class="team_info">
                                <h4>李斌</h4>
                                <p>蔚来汽车董事长兼CEO</p>
                            </div>
                        </div>
                    </div>


                    <div class="col-md-4 col-sm-12">
                        <div class="team-box">
                            <div class="team_img">
                                <img src="../../public/static/picture/head_logo2.png" alt="">
                            </div>
                            <div class="team_info">
                                <h4>李斌</h4>
                                <p>蔚来汽车董事长兼CEO</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-12">
                        <div class="team-box">
                            <div class="team_img">
                                <img src="../../public/static/picture/head_logo2.png" alt="">
                            </div>
                            <div class="team_info">
                                <h4>李斌</h4>
                                <p>蔚来汽车董事长兼CEO</p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </section>
        <!-- end team section -->

        <!-- blog section -->
       <section class="blog-section">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-4">
                        <div class="blog-header-title">
                            <small>Articles & Tips</small>
                            <h3>Latest News</h3>
                        </div>
                        <div class="blog_info">
                            <a href="blog-detail.html">
                                <h4>How To Eat Organic Foods</h4>
                            </a>
                            <div class="d-flex align-items-center justify-content-between">
                                <div class="blog_date"><span> <i class="bi bi-calendar"></i>6 Nov 2023</span></div>
                                <span class="blog_read"><a href="blog-detail.html">Read more</a><i class="icon-right-open"></i></span>
                            </div>
                        </div>
                        <div class="blog_info">
                            <a href="blog-detail.html">
                                <h4>How To Eat Organic Foods</h4>
                            </a>
                            <div class="d-flex align-items-center justify-content-between">
                                <div class="blog_date"><span> <i class="bi bi-calendar"></i>6 Nov 2023</span></div>
                                <span class="blog_read"><a href="blog-detail.html">Read more</a><i class="icon-right-open"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8 col-sm-12">
                        <div class="row">
                            <div class="col-md-6 col-sm-12">
                                <div class="post-box">
                                    <div class="post-img"><img src="static/picture/blog1.jpg" class="img-fluid" alt=""></div>
                                    <div class="post_info">
                                        <a href="blog-detail.html">
                                            <h4>How To Find And Afford<br> Organic Food In Your Area</h4>
                                        </a>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between">
                                        <div class="blog_date"><span> <i class="bi bi-calendar"></i>6 Nov 2023</span>
                                        </div>
                                        <span class="blog_read"><a href="blog-detail.html">Read more</a><i class="icon-right-open"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">
                                <div class="post-box">
                                    <div class="post-img"><img src="static/picture/blog2.jpg" class="img-fluid" alt=""></div>
                                    <div class="post_info">
                                        <a href="blog-detail.html">
                                            <h4>How To Find And Afford<br> Organic Food In Your Area</h4>
                                        </a>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between">
                                        <div class="blog_date"><span> <i class="bi bi-calendar"></i>6 Nov 2023</span>
                                        </div>
                                        <span class="blog_read"><a href="blog-detail.html">Read more</a><i class="icon-right-open"></i></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end blog section -->

        <!-- footer section -->
        <footer class="footer-section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="footer-col-1">
<!--                            <div>
                                <a href="javascript:void(0)"><img src="static/picture/footer_logo.png" alt="" class="footer-logo"></a>
                            </div> -->
                            <p style="font-size: 25px;margin-left: 20px;">
                                安徽省优势产能云服务<br><br>推荐系统
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-12">
                        <div class="footer-col-2">
                            <h5 class="widget-title">关于我们</h5>
                            <a href="javascript:void(0)">系统简介</a>
                            <br><br>
                            <a href="javascript:void(0)">发展历程</a>
                            <br><br>
                            <a href="javascript:void(0)">关注我们</a>
                        </div>
                    </div>

                    <div class="col-lg-3 col-sm-12">
                        <div class="footer-col-2">
                            <h5 class="widget-title">联系我们</h5>
                            <a href="javascript:void(0)">客户服务</a>
                            <br><br>
                            <a href="javascript:void(0)">合作洽谈</a>
                            <br><br>
                            <a href="javascript:void(0)">监督举报</a>
                        </div>
                    </div>

                    <div class="col-lg-3 col-sm-12">
                        <div class="footer-col-2">
                            <h5 class="widget-title">法律信息</h5>
                            <a href="javascript:void(0)">服务协议</a>
                            <br><br>
                            <a href="javascript:void(0)">隐私政策</a>
                            <br><br>
                            <a href="javascript:void(0)">知识产权</a>
                        </div>
                    </div>

                    <!-- <div class="scrollup"><span class="icon-glyph-203"></span></div> -->
                </div>
            </div>
            <div class="subfooter">
                <p>Copyright &copy; 安徽省优势产能云服务推荐系统开发团队版权所有</p>
            </div>
        </footer>
        <!--end footer section -->

    </main>

  </div>

</template>

<script>
  // script linked
  // import './static/js/swiper-bundle.min.js';
  // import './static/js/bootstrap-icons.json';
  // import './static/js/jquery-3.6.0.min.js';
  // import './static/js/bootstrap.min.js';
  // import './static/js/custom.js';
  import './static/js/jquery.magnific-popup.js';
  import Swiper from 'swiper';
  import "swiper/swiper.min.css"
  // import 'swiper/dist/css/swiper.min.css'

  window.WIDGET = {
    "CONFIG": {
      "layout": "1",
      "width": "550",
      "height": "250",
      "background": "1",
      "dataColor": "B6D7A8",
      "borderRadius": "5",
      "city": "CN101220307",
      "key": "56e96ad05ac54bedbb93a70a4d28cfa9"
    }
  }

  import { defineComponent, ref, reactive, toRefs, onMounted } from "vue";
  import $ from 'jquery';

	export default {
		data() {
			return {
				pictures: [             //轮播图
					{src: "./static/picture/slideshow1.jpg",alt: "一带一路 ",index: "0",ref: "picture"},
					{src: "./static/picture/slideshow2.jpg",alt: "汽车",index: "1",ref: "picture"},
					{src: "./static/picture/slideshow6.jpg",alt: "茶叶",index: "2",ref: "picture"},
					{src: "./static/picture/slideshow5.jpg",alt: "黄山",index: "3",ref: "picture"},
					{src: "./static/picture/slideshow4.jpg",alt: "电子",index: "4",ref: "picture"},
				],
        goods: [],              //产品列表
				mouseEnter: false,      //鼠标是否悬浮在整个区域上
				pictureShowing: 0,      //当前展示的是第几张图片，用来更新底部圆点
				hasClicked:false,       //函数节流，防止用户快速、频繁点击图片变换导致出错，flase为图片变换操作不可执行
        speed:80,               //图片移动速度
        offsetWidth:600,        //轮播图宽度，将在mounted里面动态获取
        topNav:this.$store.state.settings.topNav,
			};
		},


		watch: {

      offsetWidth(){        //当轮播图宽度改变时
        this.$refs.myul.style.left=0+"px";      //回到第一张图片
        this.pictureShowing = 0;
      },

      topNav(){              //用来监测topNav的改变
        this.$refs.myul.style.left=0+"px";
        this.pictureShowing = 0;
      },

			pictureShowing(newval) {                //当改变图片时，更新底部小圆圈
				for (let i = 0; i < this.pictures.length; i++) {
					(this.$refs.cicle)[i].style.background = "";
				}
				(this.$refs.cicle)[newval].style.background = "black";
			}
		},

    beforeDestroy() {
      if (this.vantaEffect) {
        this.vantaEffect.destroy()
      }
    },

    created() {

    },

    mounted() {

        let timer = setInterval(() => {           //每0.5秒更新topNav和offsetWidth
            this.topNav = this.$store.state.settings.topNav;
            this.offsetWidth = this.getOffsetWidth();     //动态获取轮播图宽度
        },500);

        let li_0 = this.$refs[`picture`][0];
        let li_end = li_0.cloneNode(true);
        this.$refs.myul.appendChild(li_end);            //克隆第一张图片，加到ul最后展示的位置

        this.$refs.myul.style.position = "absolute";
        this.$refs.myul.style.left = 0 + "px";

        this.$refs.cicle[0].style.background = "black";    //挂载时展示第一张图片，默认第一个圆圈被填充

        this.$nextTick(() => {
            this.load();
        });

        // this.$nextTick(() => {
        //     new Swiper ('.swiper', {
        //         slidesPerView: 2,
        //         spaceBetween: 20,
        //         //设置自动播放
        //         autoplay: true,
        //         loop: true,
        //         // speed: 1000,
        //         // slidesOffsetBefore : 50,
        //         // slidesOffsetAfter : 50,
        //         notNextTick: true,
        //         observer:true,//修改swiper自己或子元素时，自动初始化swiper
        //         observeParents:true,//修改swiper的父元素时，自动初始化swiper
        //         // // 如果需要分页器
        //         // pagination: '.swiper-pagination',
        //         // // 如果需要前进后退按钮
        //         // nextButton: '.swiper-button-next',
        //         // prevButton: '.swiper-button-prev',
        //         // // 如果需要滚动条
        //         // scrollbar: '.swiper-scrollbar',
        //       });
        // });

    },

	    methods: {
          getOffsetWidth(){
            var outestElt = document.getElementById("slide");
            var offsetWidth = outestElt.offsetWidth;
            return offsetWidth;
          },
	        changeDefault(speed) {                  //切换下一张图片    speed为每毫秒移动的距离
              this.offsetWidth = this.getOffsetWidth();     //动态获取轮播图宽度
	            let t = 0;                          //根据每秒移动的位移控制单次位移结束
	            let timer = setInterval(() => {
	                t++;
	                this.$refs.myul.style.left = this.$refs.myul.offsetLeft - Number(speed) + "px";

	                if (t >= this.offsetWidth/speed) {
	                    if(this.$refs.myul.offsetLeft<=-1*this.offsetWidth*5){             //当最后一张图片（第一张的克隆）刚好完全展示时回到第一张完全展示时的位置
	                        this.$refs.myul.style.left=0+"px";
	                    }
	                    clearInterval(timer);
	                    this.hasClicked=false;
                      t = 0;
	                }
	            }, 1);
	        },
	        quickTurn(count,index,method) {              //count为用户点击的点与当前 被填充点 的距离
              this.offsetWidth = this.getOffsetWidth();     //动态获取轮播图宽度
              // alert("width:"+this.offsetWidth+"    left:"+this.$refs.myul.offsetLeft);
	            let currentX = this.$refs.myul.offsetLeft;
	            let t = setInterval(() => {
                if(method === "next"){
                  if(this.$refs.myul.offsetLeft >= -1*this.offsetWidth*index+count*this.speed){
                    this.$refs.myul.style.left = this.$refs.myul.offsetLeft - count * this.speed + "px";
                  }else{
                    this.$refs.myul.style.left = this.$refs.myul.offsetLeft - count * 1 + "px";
                  }
                }
                if(method === "last"){
                  if(this.$refs.myul.offsetLeft <= -1*this.offsetWidth*index+count*this.speed){
                    this.$refs.myul.style.left = this.$refs.myul.offsetLeft - count * this.speed + "px";
                  }else{
                    this.$refs.myul.style.left = this.$refs.myul.offsetLeft - count * 1 + "px";
                  }
                }

                if (this.$refs.myul.offsetLeft === currentX - this.offsetWidth * count) {     //刚好到达目的图片
                    if(index===0){
                        this.$refs.myul.style.left=0+"px";
                    }
                    clearInterval(t);
                    this.hasClicked=false;
                }
	            }, 1);
	        },
	        gotoPicture(index,method) {
	            let id = Number(index);
	            let showing = this.pictureShowing;
	            if (id === showing) {
	                return null;
	            } else {
	                this.quickTurn(index - showing,index,method);
	                this.pictureShowing = index;
	            }
	        },
	        gotoLast(){             //上一张
              this.offsetWidth = this.getOffsetWidth();     //动态获取轮播图宽度
	            if(this.hasClicked){
	                return null;
	            }
	            this.hasClicked=true;
	            if(Number(this.pictureShowing)===0){
	                this.$refs.myul.style.left=-1*this.offsetWidth*5+"px";
	                this.pictureShowing=this.pictures.length-1;
	                this.quickTurn(-1,this.pictureShowing,"last");
	            }else{
	                this.gotoPicture(this.pictureShowing-1,"last");
	            }
	        },
	        gotoNext(){             //下一张
	            if(this.hasClicked){
	                return null;
	            }
	            this.hasClicked=true;
	            if(Number(this.pictureShowing)===this.pictures.length-1){
	                this.changeDefault(this.speed);
	                this.pictureShowing=0;
	            }else{
	                this.gotoPicture(this.pictureShowing+1,"next")
	            }
	        },
	        gotoDirectly(index){    //跳到某一张
	            if(this.hasClicked){
	                return null;
	            }
	            this.hasClicked=true;
              if(index>this.pictureShowing){
                this.gotoPicture(index,"next");
              }else{
                this.gotoPicture(index,"last");
              }

	        },

          load() {
              const s = document.createElement('script')
              s.type = 'text/javascript'
              s.src =
                'https://widget.qweather.net/standard/static/js/he-standard-common.js?v=2.0'
              document.body.appendChild(s)
          },

          mapInit({BMap, map}){
              this.map = map
              var point = new BMap.Point(118.385422, 31.288817)  //设置城市经纬度坐标
              map.centerAndZoom(point, 15)    //
              map.setCurrentCity('芜湖')   // 设置地图显示的城市 此项是必须设置的
              map.enableScrollWheelZoom(true)    //鼠标滚动缩放

          }
	    }
	};

</script>

<style lang="scss" scoped>
  @import './static/css/magnific-popup.css';
  @import './static/css/custom-icons.css';
  @import './static/css/swiper-bundle.min.css';
  @import './static/css/boxicons.min.css';
  @import './static/css/bootstrap-icons.css';
  @import './static/css/bootstrap.min.css';
  @import './static/css/style.css';

.tt {
  max-width: 30px;
  height: auto;
}

.box-card {
    width: 50%;
    margin-left:25px;
  }

  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    height: 650px;
  }
  .bg-purple {
    // background: #d3dce6;
  }
  .bg-purple-light {
    // background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 200px;
  }
  .row-bg {
    padding: 10px 0;
    // background-color: #f9fafc;
  }

  .outest {
        width: 100%;
        height: 650px;
        padding: 0px;
        position: absolute;
        overflow: hidden;
        cursor: pointer;
        // background-color: bisque;
    }

  // 轮播图文字设置
  .slider-child{
    position: absolute;
    z-index: 999;
    left: 100px;
  }

  /** 轮播图片设置 */
  ul {
      margin: 0px;
      padding: 0px;
      width: calc(6 * 100%);
      height: 100%;
  }
  ul > li {
      width: calc(1 / 6 * 100%);
      height: 100%;
      list-style: none;
      float: left;
  }
  li > img {
      width: 100%;
      height: 100%;
  }
  /* 左右图标设置 */
  .icon {
      width: 60px;
      height: 60px;
      position: absolute;
      top: 270px;
      z-index: 2;
      opacity: 0.5;
  }
  ._left {
      left: 0px;
  }
  ._right {
      right: 0px;
  }
  /* 底部小圆圈的设置 */
  .mydiv {
      width: auto;
      height: 30px;
      display: inline-block;
      position: absolute;
      bottom: 0px;
      left: 45%;
      z-index: 5;
      opacity: 0.5;
  }
  .empty-cicle {
      display: inline-block;
      width: 10px;
      height: 10px;
      border: 2px solid black;
      border-radius: 90px;
      z-index: 5;
      margin-right: 5px;
  }

  a {
    color: white;
    transition: all 0.3s;
    text-decoration: none;
  }

  a:hover {
    color: deepskyblue;
  }

 // .mapDiv {
 //   width: 500px; height: 500px;
 //  }

  #map {
    width: 100%;
    height: 550px;
  }

  #sliderLink {
    width: 100%;
    height: 500px;
  }

</style>
