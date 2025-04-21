<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Guitar Shop</title>
    <link rel="stylesheet" type ="text/css" href="css/product.css" />
</head>
<body>
    <!-- navigation bar of our website -->
    <nav>
        <div class="container">
            <div class="logo">
                <a href="home"><img src="${pageContext.request.contextPath}/resources/images/system/logo.png" alt="logo"></a>
            </div>
            <div class="links">
                <a href="home">Home</a>
                <a href="product">Products</a>
                <a href="login.">Login</a>
                <a href="register">Register</a>
                <a href="contact">Contact</a>
               
            </div>
           

        </div>
    </nav>
    <header>
        <div class="main-flex-container"> 
        
            <a href="product1" class="anchor"> 
                <div class="flex-items">
                    <div class="img-box">
                        <img src="${pageContext.request.contextPath}/resources/images/system/g1.jpg">
                    </div>
                    <div class="text-box">
                        <h1> Fendor CD-60SK</h1>
                        <h2>Rs. 15,000</h2>   
                    </div>
                                    
                <div class="product-page-button2">
                        <button>Buy Now</button></div>
                </div>
            </a>
            
            <a href="product2" class="anchor">
                <div class="flex-items">
                    <div class="img-box">
                        <img src="${pageContext.request.contextPath}/resources/images/system/g2.jpg">
                    </div>
                    <div class="text-box">
                        <h1>Yamaha FG800J NT </h1>
                        
                        <h2>Rs. 10,000</h2>
                       
                      
                    </div> <div class="product-page-button2">
                            <button>Buy Now</button></div>
                </div>
            </a>
            <a href="product3" class="anchor">
                <div class="flex-items">
                    <div class="img-box">
                        <img src="${pageContext.request.contextPath}/resources/images/system/g3.jpg">
                    </div>
                    <div class="text-box">
                        <h1>Dandy Parlor</h1>
                        
                        <h2>Rs. 15,500</h2>
                        
                       
                    </div><div class="product-page-button3">
                            <button>Buy Now</button></div>
                </div>
            </a>
            <a href="product4" class="anchor">
                <div class="flex-items">
                    <div class="img-box">
                        <img src="${pageContext.request.contextPath}/resources/images/system/g4.jpg">
                    </div>
                    <div class="text-box">
                        <h1>Mantra G12</h1>
                         
                        <h2>Rs. 12,000</h2><br><br>
                       
                       
                    </div> <div class="product-page-button4">
                            <button>Buy Now</button></div>
                </div>
            </a>
        </div>
       <div class="main-flex-container2">  <!-- creating another Div to hold more products-->
            <a href="product5" class="anchor">
                <div class="flex-items">
                    <div class="img-box">
                        <img src="${pageContext.request.contextPath}/resources/images/system/uk1.jpg" style="scale: 135%;">
                    </div>
                    <div class="text-box">
                        <h1>JOY MUSIC UK235</h1>
                        
                        <h2>Rs. 4,000</h2>
                       
                       
                    </div> <div class="product-page-button5">
                            <button>Buy Now</button></div>
                </div>
            </a>
            <a href="product6" class="anchor">
                <div class="flex-items">
                    <div class="img-box">
                        <img src="${pageContext.request.contextPath}/resources/images/system/uk2.jpg">
                    </div>
                    <div class="text-box">
                        <h1>Yamaha GL1</h1>
                        
                        <h2>Rs.9,000 </h2>
                        
                       
                    </div><div class="product-page-button6">
                            <button>Buy Now</button></div>
                </div>
            </a>
            <a href="product7" class="anchor">
                <div class="flex-items">
                    <div class="img-box">
                        <img src="${pageContext.request.contextPath}/resources/images/system/uk3.jpg">
                    </div>
                    <div class="text-box">
                        <h1>Fendor Venice Soprano</h1>
                        
                        <h2>Rs. 5,000</h2>
                       
                        
                    </div>
                     <div class="product-page-button7">
                            <button>Buy Now</button></div>
                </div>
            </a>
            <a href="product8" class="anchor">
                <div class="flex-items">
                    <div class="img-box">
                        <img src="${pageContext.request.contextPath}/resources/images/system/uk4.jpg">
                    </div>
                    <div class="text-box">
                        <h1>Dream Maker UK21</h1>
                       
                        <h2>Rs. 4,000</h2><br><br>
                    
                        
                      
                    </div><div class="product-page-button8">
                            <button>Buy Now</button></div>
                </div>
            </a>
            </div>
    </header>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

        <!-- footer codes -->
        
        <footer>
            <section class="footer">
            
                <div class="row">
                    <div class="col">
                        <a href=""><img src="${pageContext.request.contextPath}/resources/images/system/logo.png"class="logo1"></a>
                        
               </div>
               
               <div class="col">
                   <h3>Developers <div class="underline"></div></h3>
               <p><a href="https://www.instagram.com/" target="_blank"> Shuvashree</a> <br> <br><a href="https://www.instagram.com/" target="_blank">Aarju</a><br>
                <br><a href="https://www.instagram.com/" target="_blank" >Swoodhin</a><br>
                <br><a href="https://www.instagram.com/" target="_blank">Pankaj</a>
               
            </p>
                
            </div>
               <div class="col">
                   <h3>Pages below<div class="underline"></div></h3>
                   <ul>
                       <li><a href="WEB-INF/pages/home.jsp">Home</a></li>
                       <li><a href="WEB-INF/pages/product.jsp" target="_blank">Products</a></li>
                       <li><a href="WEB-INF/pages/login.jsp">Login</a></li>
                       
                <li><a href="WEB-INF/pages/register.jsp" target="_blank">Register</a></li>
                <li><a href="WEB-INF/pages/contact.jsp">Contact</a></li>
            
                   </ul>
               </div>           
               
        </div>                    
        
            </section> 
         </footer>
</body>
</html>
