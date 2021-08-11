
    function addNewImage() {
    let form = document.getElementById("add-image");
    let data = new FormData(form);
    $.ajax({
    type: "POST",
    enctype: 'multipart/form-data',
    url: "http://localhost:8011/api/images/rest/upload",
    data: data,
    processData: false,
    contentType: false,
    cache: false,
    timeout: 1000000,
    success: findAll
    //function (data) {
    // document.getElementById('main').innerHTML = `${data.home}<img src="image/${data.image}">`
    // }
});
    event.preventDefault();
}
    // function addNewImage() {
    //     let image = $('#image').val();
    //     let home = $('#home').val();
    //     let newImage = {
    //         image: image,
    //         home: {id: home}
    //     };
    //
    //     $.ajax({
    //         headers: {
    //             'Accept': 'application/json',
    //             'Content-Type': 'application/json'
    //         },
    //         type: "POST",
    //         data: JSON.stringify(newImage),
    //         url: "http://localhost:8011/api/images",
    //         success: findAll
    //     });
    //     event.preventDefault();
    // };
    function findAll() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8011/api/images",
            success: function (data) {
                let content = '   <table class="table table-striped"><tr>\n' +
                    '        <td>Image</td>\n' +
                    '        <td>Home_name</td>\n' +
                    '        <td>Type_home</td>\n' +
                    '        <td>Type_room</td>\n' +
                    '        <td>address</td>\n' +
                    '        <td>num_bedroom</td>\n' +
                    '        <td>num_bathroom</td>\n' +
                    '        <td>description</td>\n' +
                    '        <td>Price</td>\n' +
                    '    </tr>';
                for (let i = 0; i < data.length; i++) {
                    content += getImage(data[i]);
                }
                content += "</table>";
                document.getElementById('main').innerHTML = content;
            }
        });
    }

    function showAll(){
    let content=`<div class="row">`;
    $.ajax({
    type: "GET",
    url: "http://localhost:8011/api/images",
    success: function (data) {
    console.log(data)
    for (let i = 0; i < data.length; i++) {
    content += `<div class="col-4">
                    <div class="card" style="width: 18rem;">
                        <img src="image/${data[i].image}" class="card-img-top" alt="..." height="200" width="200">
                        <div class="card-body">
                            <h5 class="card-title">${data[i].home.home_Name}</h5>
                            <p class="card-text">${data[i].home.price}</p>
                            <a href="#" onclick="detail(${data[i].id})" class="btn btn-primary">view</a>
                        </div>
                    </div>
                </div>`;
}
    content +=`</div>`;
    document.getElementById('show').innerHTML = content;
}
});

}
function detail(id){
    $.ajax({
        type: "GET",
        url: "http://localhost:8011/api/images/" + id,
        success: function (data) {
            console.log(data);
            document.getElementById("inforhouse").innerHTML = `<div style="text-align: center">
<img src="image/${data.image}" style="width: 500px" height="500">
<p>${data.home.home_Name}</p>
<p>${data.home.type_Home}</p>
<p>${data.home.type_Room}</p>
<p>${data.home.address}</p>
<p>${data.home.num_Bedroom}</p>
<p>${data.home.num_Bathroom}</p>
<p>${data.home.description}</p>
<p>${data.home.price}</p>
<a href="#" class="btn btn-primary">Đặt phòng</a>
</div>`;

        }
    });
    event.preventDefault();

}

    function getImage(image) {
    return `<tr><td ><img height="100" width="100" src="image/${image.image}"</td><td>${image.home.home_Name}</td><td >${image.home.type_Home}</td><td>${image.home.type_Room}</td><td>${image.home.address}</td><td>${image.home.num_Bedroom}</td><td>${image.home.num_Bathroom}</td><td>${image.home.description}</td><td>${image.home.price}</td>` +
    `<td><a class="btn btn-danger" onclick="deleteImage(${image.id})" >Delete</a></td><td><a class="btn btn-warning" onclick="edit(${image.id})" >Edit</a></td></tr>`;
}
    function showFormCreate() {
    $.ajax({
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
},
    type: "GET",
    url: "http://localhost:8011/api/homes",
    success: function (data) {
    let str = "";
    str += "<form enctype=\"multipart/form-data\" id=\"add-image\">\n" +
    "    <table class='table table-striped'>\n" +
    "        <tr>\n" +
    "            <td>Image:</td>\n" +
    "            <td><input type=\"file\" name=\"image\" placeholder=\"image\"></td>\n" +
    "        </tr>\n" +
    "        <tr>\n" +
    "            <td>Home:</td>\n" +
    "            <td><select name='home'> ";
    for (let i = 0; i < data.length; i++) {
    str += "<option value='" + data[i].id + "'>" + data[i].home_Name + "</option>"
}
    str += "</select>";
    str +=
    " </td>\n" +
    "        </tr>\n" +
    "        <tr>\n" +
    "            <td></td>\n" +
    "            <td><button class='btn btn-success' type=\"button\" onclick=\"addNewImage()\">SAVE</button></td>\n" +
    "        </tr>\n" +
    "    </table>\n" +
    "</form>";
    document.getElementById('main').innerHTML = str;
    // document.getElementById("create").innerHTML = "";
}
})
}
    function deleteImage(id) {
    let check = confirm("Are you sure to delete ??? ");
    if(check == true){
    $.ajax({
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
},
    type: "DELETE",
    data: JSON.stringify(id),
    url: "http://localhost:8011/api/images/" + id,
    success: findAll
})
}
}
    function getImage1() {
    $.ajax({
    type: "GET",
    url: "http://localhost:8011/api/homes",
    success: function (list) {
    console.log(list)
    let str = "";
    for (let i = 0; i < list.length; i++) {
    str += "<option id='id-edit' value='" + list[i].id + "'>" + list[i].home_Name + "</option>\n";

}
    document.getElementById("abc").innerHTML = str;
}
});
}
    function edit(id) {
    $.ajax({
    type: "GET",
    url: "http://localhost:8011/api/images/" + id,
    success: function (image) {
    let image1 = image.image;
    let home = image.home;
    let str = `<input type="hidden" id="edit-id" value="${id}"><table class='table table-dark table-striped'>
                            <tr>
                                <td>image:</td>
                                <td><input type="text" id="edit-image" value=${image1}></td>
                           </tr>

                           <tr>
                                <td>image name</td>
                               <td>
                               <select id="abc"  >
` + getImage1() + `
</select>
                               </td>
                           </tr>
                           <tr>
                                <td></td>
                               <td><button type="button" id="save" onclick="editImage()" >Save</td>
                           </tr>
                       </table>`;


    document.getElementById("main").innerHTML = str;

}
});
    event.preventDefault();
}
    function editImage() {
    let id = document.getElementById("edit-id").value;
    let image = document.getElementById("edit-image").value;
    let homeId = document.getElementById("abc").value;
    console.log(homeId);
    let image1 = {
    "image": image,
    "home": {
    "id": homeId
}
}
    $.ajax({
    headers: {
    'Accept': 'application/json',
    'Content-type': 'application/json'
},
    type: "PUT",
    data: JSON.stringify(image1),
    url: "http://localhost:8011/api/images/" + id,
    success: findAll
})
    event.preventDefault();
}
    function searchHomeByAddress() {
    let address = $('#addressSearch');
    let value = address.val();

    $.ajax({
    type: 'GET',
    url: 'http://localhost:8011/api/images/search/' + value,
    success: function (imageList) {
    let str =
    "<h1 style='margin-left: 30%'>List Image</h1>" +
    "<table class='table table-dark table-striped'>\n" + "<tr>\n" +
    "<th>image</th>\n" +
    "<th>home_Name</th>\n" +
    "<th>type_Room</th>\n" +
    "<th>type_Home</th>\n" +
    "<th>address</th>\n" +
    "<th>num_Bedroom</th>\n" +
    "<th>num_Bathroom</th>\n" +
    "<th>description</th>\n" +
    "<th>price</th>\n" +
    "<th>Edit</th>\n" +
    "<th>Delete</th>\n" +
    "</tr>\n";
    console.log(imageList)
    for (let i = 0; i < imageList.length; i++) {
    str += "<tr><td>" + imageList[i].image;
    str += "<tr><td>" + imageList[i].home.home_Name;
    str += "</td><td>" + imageList[i].home.type_Room;
    str += "</td><td>" + imageList[i].home.type_Home;
    str += "</td><td>" + imageList[i].home.address;
    str += "</td><td>" + imageList[i].home.num_Bathroom;
    str += "</td><td>" + imageList[i].home.num_Bedroom;
    str += "</td><td>" + imageList[i].home.description;
    str += "</td><td>" + imageList[i].home.price;
    str += "</td><td>" + '<button type="button" onclick="edit(' + imageList[i].id + ')"> Edit </button> ';
    str += "</td><td>" + ' <button  type="button" onclick="deleteHome(' + imageList[i].id + ')"> Delete</button> ';
    str += "</td>"
}
    str += "</table>"
    document.getElementById('main').innerHTML = str;
}
})
    event.preventDefault();
}
    function searchHomeByPrice() {
    let price1 = $('#addpriceSearch1');
    let price2 = $('#addpriceSearch2');
    let value1 = price1.val();
    let value2 = price2.val();

    $.ajax({
    type: 'GET',
    url: 'http://localhost:8011/api/images/find/' + value1 +","+value2,
    success: function (imageList) {
    let str =
    "<h1 style='margin-left: 30%'>List Image</h1>" +
    "<table class='table table-dark table-striped'>\n" + "<tr>\n" +
    "<th>image</th>\n" +
    "<th>home_Name</th>\n" +
    "<th>type_Room</th>\n" +
    "<th>type_Home</th>\n" +
    "<th>address</th>\n" +
    "<th>num_Bedroom</th>\n" +
    "<th>num_Bathroom</th>\n" +
    "<th>description</th>\n" +
    "<th>price</th>\n" +
    "<th>Edit</th>\n" +
    "<th>Delete</th>\n" +
    "</tr>\n";
    console.log(imageList)
    for (let i = 0; i < imageList.length; i++) {
    str += "<tr><td>" + imageList[i].image;
    str += "<tr><td>" + imageList[i].home.home_Name;
    str += "</td><td>" + imageList[i].home.type_Room;
    str += "</td><td>" + imageList[i].home.type_Home;
    str += "</td><td>" + imageList[i].home.address;
    str += "</td><td>" + imageList[i].home.num_Bathroom;
    str += "</td><td>" + imageList[i].home.num_Bedroom;
    str += "</td><td>" + imageList[i].home.description;
    str += "</td><td>" + imageList[i].home.price;
    str += "</td><td>" + '<button type="button" onclick="edit(' + imageList[i].id + ')"> Edit </button> ';
    str += "</td><td>" + ' <button  type="button" onclick="deleteHome(' + imageList[i].id + ')"> Delete</button> ';
    str += "</td>"
}
    str += "</table>"
    document.getElementById('main').innerHTML = str;
}
})
    event.preventDefault();
}
    function searchAllHome() {
    let pricemin = $('#pricemin');
    let pricemax = $('#pricemax');
    let address = $('#address');
    let num_bedroom = $('#num_bedroom');
    let num_bathroom = $('#num_bathroom');
    let value1 = pricemin.val();
    let value2 = pricemax.val();
    let value3 = address.val();
    let value4 = num_bedroom.val();
    let value5 = num_bathroom.val();

    $.ajax({
    type: 'GET',
    url: 'http://localhost:8011/api/images/tim/' + value1 +","+value2 +"," + value3 +","+value4 +"," +value5,
    success: function (imageList) {
    let str =
    "<h1 style='margin-left: 30%'>List Image</h1>" +
    "<table class='table table-dark table-striped'>\n" + "<tr>\n" +
    "<th>image</th>\n" +
    "<th>home_Name</th>\n" +
    "<th>type_Room</th>\n" +
    "<th>type_Home</th>\n" +
    "<th>address</th>\n" +
    "<th>num_Bedroom</th>\n" +
    "<th>num_Bathroom</th>\n" +
    "<th>description</th>\n" +
    "<th>price</th>\n" +
    "<th>Edit</th>\n" +
    "<th>Delete</th>\n" +
    "</tr>\n";
    console.log(imageList)
    for (let i = 0; i < imageList.length; i++) {
    str += "</td><td>" + imageList[i].home.type_Room;
    str += "</td><td>" + imageList[i].home.type_Home;
    str += "</td><td>" + imageList[i].home.address;
    str += "</td><td>" + imageList[i].home.num_Bathroom;
    str += "</td><td>" + imageList[i].home.num_Bedroom;
    str += "</td><td>" + imageList[i].home.description;
    str += "</td><td>" + imageList[i].home.price;
    str += "</td><td>" + '<button type="button" onclick="edit(' + imageList[i].id + ')"> Edit </button> ';
    str += "</td><td>" + ' <button  type="button" onclick="deleteHome(' + imageList[i].id + ')"> Delete</button> ';
    str += "</td>"
}
    str += "</table>"
    document.getElementById('main').innerHTML = str;
}
})
    event.preventDefault();
}


