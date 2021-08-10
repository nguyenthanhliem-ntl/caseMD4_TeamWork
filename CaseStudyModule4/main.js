function containerComponent() {
    let str = '<div class="container">\n' +
        '    <div class="row" id="menu">\n' +
        '        \n' +
        '    </div>\n' +
        '    <div class="row mt-3" id="search">\n' +
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
        "          <a class=\"nav-link\" href=\"trangCaNhan.html\">Link</a>\n" +
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
    let str =
        "<div class=\"col-8\" id='home_card' style='text-align: center'>Thuê Nhà Đất Giá Rẻ Tại Việt Nam, Giá Thuê Mới Nhất" +
        "<div class=\"card mb-3\" style=\"max-width: 540px;\">\n" +
        "  <div class=\"row g-0\">\n" +
        "    <div class=\"col-md-4\">\n" +
        "      <img src=\"...\" class=\"img-fluid rounded-start\" alt=\"...\">\n" +
        "    </div>\n" +
        "    <div class=\"col-md-8\">\n" +
        "      <div class=\"card-body\">\n" +
        "        <h5 class=\"card-title\">Card title</h5>\n" +
        "        <p class=\"card-text\">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>\n" +
        "        <p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "  </div>\n" +
        "</div>"+
        "</div>\n" +
        "<div class=\"col-4\" id='view'>Home</div>"
    document.getElementById('main').innerHTML = str;
}

function mainSearch() {
    let str = "<div class=\"col-12\" id=\"search\">abcdef</div>"
    document.getElementById('search').innerHTML = str;
}