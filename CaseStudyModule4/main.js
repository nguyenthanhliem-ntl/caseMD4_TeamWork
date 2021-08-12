function containerComponent() {
    let str = '<div class="container">\n' +
        '    <div class="row" id="menu">\n' +
        '        \n' +
        '    </div>\n' +
        '    <div class="row mt-3" id="search">\n' +
        '        \n' +
        '    </div>\n' +
        '    <div class="row mt-3" id="main">\n' +
        '<div class="col-8" id="post"></div>' +
        '<div class="col-4" id="view"></div>' +
        '    </div>\n' +
        '</div>'
    document.getElementById('content').innerHTML = str;
}

function menuComponent() {
    let str = "<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
        "    <a class=\"navbar-brand\" href=\"#\">Web Thuê Nhà</a>\n" +
        "    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
        "        <span class=\"navbar-toggler-icon\"></span>\n" +
        "    </button>\n" +
        "\n" +
        "    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
        "        <ul class=\"navbar-nav mr-auto\">\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\" href=\"#\">Home</a>\n" +
        "            </li>\n" +
        "            <li class=\"nav-item\">\n" +
        "                <a class=\"nav-link\" href=\"createHome.html\">Đăng bài</a>\n" +
        "            </li>\n" +
        "\n" +
        "            <li class=\"nav-item\">\n" +
        "                <a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Disabled</a>\n" +
        "            </li>\n" +
        "            <li class=\"nav-item\">\n" +
        "                <p class=\"nav-link disabled\"  tabindex=\"-1\" aria-disabled=\"true\" id='name'></p>\n" +
        "            </li>\n" +
        "        </ul>\n" +
        "        <div id=\"log\">\n" +
        "      <button class=\"btn btn-outline-success\" onclick='showFormLogin()'>Login</button>     \n" +
        "        </div>\n" +
        "    </div>\n" +
        "</nav>"
    document.getElementById('menu').innerHTML = str;
}

function showFormLogin() {
    window.location.href = "login.html";
}

function hasUserLogin() {
    let userLogin = JSON.parse(localStorage.getItem("acc"));
    if (userLogin != null) {
        let str = document.getElementById("log").innerHTML = `<button class=\"btn btn-outline-success\" onclick='hasUserLogout()'>Logout</button>`
        let str1 = document.getElementById("name").innerHTML = `<p>Hello ${userLogin.username}</p>`
    }
}

function hasUserLogout() {
    localStorage.clear();
    window.location.href = "home.html";
}

function mainSearch() {
    let str = "<div class=\"col-12\" id=\"search\">abcdef</div>"
    document.getElementById('search').innerHTML = str;
}

function mainHomeComponent() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "http://localhost:8080/api/homes",
        success: function (homes) {
            let str = "<h4>Danh sách nhà cho thuê</h4>";
            for (let i = 0; i < homes.length; i++) {
                $.ajax({
                    type: "GET",
                    contentType: "application/json",
                    url: "http://localhost:8080/api/images/findAllImage/" + homes[i].id,
                    success: function (images) {
                        str += `
<div class="card mb-3" style="max-width: 1000px;">
  <div class="row g-0">
    <div class="col-md-4" id="img">
      <img src="images/${images[0].image}" class="img-fluid rounded-start" alt="..." style="height: 260px;width: 450px">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <a class="card-title" onclick="viewHome(${homes[i].id})">${homes[i].home_Name}</a>
        <p class="card-text">Loại phòng :${homes[i].type_Room}, Loại nhà : ${homes[i].type_Home}</p>
        <p class="card-text">Địa chỉ : ${homes[i].address}</p>
        <p class="card-text">Số giường :${homes[i].num_Bedroom}, Số phòng tắm : ${homes[i].num_Bathroom}</p>
        <p class="card-text">Giá : ${homes[i].price} VNĐ / 1 ĐÊM</p>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      </div>
    </div>
  </div>
</div>\n`
                        document.getElementById('post').innerHTML = str;
                    }
                })
            }
        }
    })

}

function viewHome(id) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "http://localhost:8080/api/images/findAllImage/" + id,
        success: function (homeImage) {

            let str = `<h1>View House</h1>
<div class="card" style="width: 25rem;">
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol><div class="carousel-inner">
   <div class="carousel-item active">
      <img src="images/${homeImage[0].image}" class="d-block w-100" alt="...">
    </div>`
            for (let i = 1; i < homeImage.length; i++) {
                str += `
    <div class="carousel-item">
      <img src="images/${homeImage[i].image}" class="d-block w-100" alt="...">
    </div>
    `
            }
            str += `</div><a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                         <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                         <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                         <span class="carousel-control-next-icon" aria-hidden="true"></span>
                         <span class="sr-only">Next</span>
                    </a>
</div>`
            str += `
<div class="card-body">
    <h5 class="card-title">${homeImage[0].home.home_Name}</h5>
    <p class="card-text">${homeImage[0].home.description}</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Số giường : ${homeImage[0].home.num_Bedroom} , Số phòng tắm : ${homeImage[0].home.num_Bathroom}</li>
    <li class="list-group-item">Kiểu nhà : ${homeImage[0].home.type_Home}, Địa chỉ : ${homeImage[0].home.address}</li>
    <li class="list-group-item">Giá : ${homeImage[0].home.price}VNĐ/1 đêm</li>
  </ul>
  <div class="card-body">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
     Đặt phòng
</button>
    <a href="#" class="card-link">Another link</a>
  </div>
</div>`
            localStorage.setItem("idHome",homeImage[0].home.id);
            document.getElementById("view").innerHTML = str;
        }
    })
}

function orderHome() {
    let user = JSON.parse(localStorage.getItem("acc"));
    if (user!=null){
    let id_home = localStorage.getItem("idHome");
    let today = new Date();
    let date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
    console.log(date)
    let first_day = new Date(document.getElementById("first_date").value)
    let first =first_day.getFullYear() + '-' + (first_day.getMonth() + 1) + '-' + first_day.getDate()
    console.log(first)
    let last_day = new Date(document.getElementById("last_date").value)
    let last = last_day.getFullYear() + '-' + (last_day.getMonth() + 1) + '-' + last_day.getDate();
    console.log(last)


    let order = {
        "user": {
            "id": user.id
        },
        "home": {
            "id": Number.parseInt(id_home)
        },
        "order_time": Date.parse(date),
        "start_date": Date.parse(first),
        "end_date":Date.parse(last)
    }


        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            data: JSON.stringify(order),
            url: "http://localhost:8080/order/create",
            success: function (){
                window.location.href="home.html"
            }
        });
        event.preventDefault();
    }else {
        window.location.href="login.html";
    }
}