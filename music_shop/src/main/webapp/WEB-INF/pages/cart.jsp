<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Shopping Cart</title>
   <link rel="stylesheet" type ="text/css" href="css/cart.css" />
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
  <h1>Your Shopping Cart</h1>

  <div class="cart-container" id="cart-container">
    <!-- Cart items will be inserted here by JavaScript -->
  </div>

  <script>
  const cart = JSON.parse(localStorage.getItem('cart')) || [];
  const container = document.getElementById('cart-container');
  
  if (cart.length === 0) {
    container.innerHTML = "<p>Your cart is empty.</p>";
  } else {
    let total = 0;

    cart.forEach(item => {
      const div = document.createElement('div');
      div.className = 'cart-item';
      div.innerHTML = `
        <span class="item-name">${item.name}</span>
        <span class="item-price">Rs${item.price.toLocaleString('en-IN')}</span>

      `;
      container.appendChild(div);
      total += item.price;
    });

    const totalDiv = document.createElement('div');
    totalDiv.className = 'total';
    totalDiv.innerText = `Total: Rs${total.toFixed(2)}`;
    container.appendChild(totalDiv);

    const checkoutBtn = document.createElement('button');
    checkoutBtn.className = 'checkout-btn';
    checkoutBtn.innerText = "Proceed to Checkout";
    container.appendChild(checkoutBtn);

    // Add Clear Cart Button
    const clearBtn = document.createElement('button');
    clearBtn.className = 'clear-cart-btn';
    clearBtn.innerText = "Clear Cart";
    clearBtn.onclick = function() {
      if (confirm("Are you sure you want to clear your cart?")) {
        localStorage.removeItem('cart');
        alert("Cart has been cleared.");
        location.reload();
      }
    };
    container.appendChild(clearBtn);
  }

  </script>
</body>
</html>
