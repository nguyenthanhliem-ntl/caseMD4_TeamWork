function containerComponent() {
    let str = '<div class="container">\n' +
        '    <div class="row" id="menu">\n' +
        '        \n' +
        '    </div>\n' +
        '    <div class="row mt-3" id="main">\n' +
        '\n' +
        '    </div>\n' +
        '</div>'
    document.getElementById('content').innerHTML = str;
}
function menuComponent() {
    let str = "<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
        "  <div class=\"container-fluid\">\n" +
        "    <a class=\"navbar-brand\" href=\"#\">Navbar</a>\n" +
        "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
        "      <span class=\"navbar-toggler-icon\"></span>\n" +
        "    </button>\n" +
        "    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
        "      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n" +
        "        <li class=\"nav-item\">\n" +
        "          <a class=\"nav-link active\" aria-current=\"page\" href=\"trangchu.html\">Home</a>\n" +
        "        </li>\n" +
        "        <li class=\"nav-item\">\n" +
        "          <a class=\"nav-link\" href=\"trangcanhan.html\">Link</a>\n" +
        "        </li>\n" +
        "        <li class=\"nav-item dropdown\">\n" +
        "          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n" +
        "            Dropdown\n" +
        "          </a>\n" +
        "          <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n" +
        "            <li><a class=\"dropdown-item\" href=\"#\">Action</a></li>\n" +
        "            <li><a class=\"dropdown-item\" href=\"#\">Another action</a></li>\n" +
        "            <li><hr class=\"dropdown-divider\"></li>\n" +
        "            <li><a class=\"dropdown-item\" href=\"#\">Something else here</a></li>\n" +
        "          </ul>\n" +
        "        </li>\n" +
        "        <li class=\"nav-item\">\n" +
        "          <a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Disabled</a>\n" +
        "        </li>\n" +
        "      </ul>\n" +
        "      <form class=\"d-flex\">\n" +
        "        <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n" +
        "        <button class=\"btn btn-outline-success\" type=\"submit\">Search</button>\n" +
        "      </form>\n" +
        "    </div>\n" +
        "  </div>\n" +
        "</nav>"
    document.getElementById('menu').innerHTML = str;
}
function mainHomeComponent() {
    let str = //"<div class=\"col-3\" id='category'>Left</div>\n" +
        "<div class=\"col-12\" id='post\' style='text-align: center\'>Mid</div>\n"
        //"<div class=\"col-2\" id='new'>Right</div>"
    document.getElementById('main').innerHTML = str;
}
function mainProfileComponent() {
    let str = "<div class=\"col-12\">Trang cá nhân</div>"
    document.getElementById('main').innerHTML = str;
}
function loadHomes() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8011/api/homes",
        success: function (chien) {
            let str = '<ul style="list-style: none">';
            for (let i = 0; i < chien.length; i++) {
                str += `<li>${chien[i].home_Name}</li><hr>`
                // str += "<li>" + nhuanh[i].name + "</li>"
            }
            str += "</ul>";
            document.getElementById('category').innerHTML = str;
        },
        error: function (tien) {
            console.log(tien);
        }
    });
}
function loadListImage() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8011/api/images",
        success: function (chien) {
            let str = "<div class=\"row\">";
            for (let i = 0; i < chien.length; i++) {
                str += `<div class="col-4 mt-3">
                            <div class="card" >
                                <img height="400" width="500" src="image/${chien[i].image}" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">${chien[i].home.home_Name}</h5>
                                    <p class="card-text">${chien[i].home.price}</p>
                        `
                // for (let j = 0; j < nhuanh[i].roles.length; j++) {
                //     str += `<p id="role">${nhuanh[i].roles[j].name}</p>`;
                // }
                str += `<a href="#" class="btn btn-primary">View</a>
                                </div>
                            </div>
                        </div>`
            }

            str += "</div>";
            document.getElementById('post').innerHTML = str;
        },
        error: function (tien) {
            console.log(tien);
        }
    });
}