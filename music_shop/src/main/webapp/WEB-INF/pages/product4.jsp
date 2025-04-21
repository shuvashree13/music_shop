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
<div class="product-page">
        <div class="individual-product-flex-container">
            <div class="img-box1"> <!--div tag to hold the image -->
               <img src="${pageContext.request.contextPath}/resources/images/system/g4.jpg">
            </div>
            <div class="text-box-2"><!-- Div to hold the text -->
               <h1>Mantra G12</h1>
                <p>
                <b><ins>Description</ins></b><br><i>Premium Quality<br>
                                                      High quality strings<br>
                                                     Famous world wide<br>
                                                     Easy to tune</i> <br>
                </p>        
               <h1>Rs. 12,000</h1>
              
            </div>
            <span class="button-2"> <button>Buy Now</button></span>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    
    <!-- footer code starts -->
<footer>
            <section class="footer">
            
                <div class="row">
                    <div class="col">
                        <a href="home"><img src="logo/logo.png"class="logo1"></a>
                        
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
                       <li><a href="/WEB-INF/pages/home.jsp">Home</a></li>
                       <li><a href="/WEB-INF/pages/product.jsp" target="_blank">Products</a></li>
                       <li><a href="#">Login</a></li>
                       
                <li><a href="#" target="_blank">Register</a></li>
                <li><a href="#">Contact</a></li>
            
                   </ul>
               </div>           
               
        </div>                    
        
            </section> 
         </footer>

</body>
</html>
