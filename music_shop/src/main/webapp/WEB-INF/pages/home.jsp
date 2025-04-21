<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- link to our custom css files -->
    <link rel="stylesheet" type ="text/css" href="css/home.css" />
    <title>Guitar Shop</title>
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
<!-- contents inside the front of our home page -->
    <section id="content" style="background-color:rgb(223, 223, 223);">
        <div class="content">
            <div class="main-content">
                <h1>DREAM MAKER </h1>
                <h2>UK21</h2>
                
                <p style="font-size: 19px;">For players who wish to experiment with diverse sounds and discover new musical genres, the Dream Maker UK21 is the perfect option because of its unique and energizing tone. For musicians looking to take their performing to the next level, this ukulele is an excellent option.</p>
                     <div class="order">
                      
                       <a href="product8"><button >Order Now </button></a>
                     </div>
            </div>
       
                <img src="${pageContext.request.contextPath}/resources/images/system/uk4.jpg" class="image">
       
        </div>
    </section>
    <!-- section end -->
         

    <!-- Guitar -->
    <section id="product1" class="section-p1">
        <h1 style="font-size: 43px;">Guitars</h1>
        <div class="procontainer">
            <div class="pro">
                
                <img src="${pageContext.request.contextPath}/resources/images/system/g1.jpg" alt="firstproduct" style="scale: 85%;">
           
                <div class="des">
                    <span>Fendor</span>
                    <h5>CD-60S</h5>
                    
                    <h4>RS.15,000</h4>
                </div>
                <div class="cart">
                <a href="product1">Buy</a></div>
            </div>


            <!-- another product -->
            <div class="pro">
                
                <img src="${pageContext.request.contextPath}/resources/images/system/g2.jpg" alt="2ndproduct" style="scale: 80%;">
           
                <div class="des">
                    <span>Yamaha</span>
                    <h5>FG800J NT</h5>
                    
                    <h4>Rs.10,000</h4>
                </div>
                <div class="cart">
                <a href="product2">Buy</a></div>
            </div>


             <!-- another product -->
             <div class="pro">
                
                <img src="${pageContext.request.contextPath}/resources/images/system/g3.jpg" alt="firstproduct" style="scale: 85%;">
           
                <div class="des">
                    <span>Grestch Jim</span>
                    <h5>Dandy Parlor</h5>
                  
                    <h4>Rs.15,500</h4>
                </div>
                <div class="cart">
                <a href="product3">Buy</a></div>
            </div>


             

        </div>
    </section>
<br>
<br>
<br>
<br>

<br>
    
    <br>
    <!-- ukelele -->

    <section id="product1" class="section-p1">
        <h1 style="font-size: 43px;">Ukeleles</h1>
        <div class="procontainer">
            <div class="pro">
                
                <img src="${pageContext.request.contextPath}/resources/images/system/uk1.jpg" alt="firstproduct" style="scale: 75%;">
           
                <div class="des1">
                    <h1>Joy Music</h1>
                    <h5>UK235</h5>
                    
                    <h4>Rs.4,000</h4>
                </div>
                <div class="cart">
                <a href="product5">Buy</a></div>
            </div>


            <!-- another product -->
            <div class="pro">
                
                <img src="${pageContext.request.contextPath}/resources/images/system/uk2.jpg" alt="2ndproduct" style="scale: 110%;">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>

                
           
                <div class="des1">
                    <h1>Yamaha</h1>
                    <h5>GL1</h5>
                    
                    <h4>Rs.9,000</h4>
                </div>
                <div class="cart">
                <a href="product6">Buy</a></div>
            </div>


             <!-- another product -->
             <div class="pro">
                
                <img src="${pageContext.request.contextPath}/resources/images/system/uk3.jpg" alt="firstproduct" style="scale: 103%;">
                
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
              
                <div class="des1">
                    <h1>Fendor</h1>
                    <h5>Venice Soprano</h5>
                   
                    <h4>Rs.5,000</h4>
                </div>
                <div class="cart">
                <a href="product7">Buy</a></div>
            </div>


             

        </div>
    </section> 
    <br>
                <br>
                <br>
                <br>
            
<hr>
<br>


        <!-- footer codes -->
        
        <footer>
            <section class="footer">
            
                <div class="row">
                    <div class="col">
                        <a href="home"><img src="${pageContext.request.contextPath}/resources/images/system/logo.png"class="logo1"></a>
                        
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
                       <li><a href="home">Home</a></li>
                       <li><a href="product" target="_blank">Products</a></li>
                       <li><a href="login">Login</a></li>
                       
                <li><a href="register" target="_blank">Register</a></li>
                <li><a href="contact">Contact</a></li>
            
                   </ul>
               </div>           
               
        </div>                    
        
            </section> 
         </footer>

</body>
</html>
