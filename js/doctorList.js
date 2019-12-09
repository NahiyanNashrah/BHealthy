var request = new XMLHttpRequest()

// Open a new connection, using the GET request on the URL endpoint
request.open('GET', 'http://localhost:8181/api/auth/doctor-list', true)
//request.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwMTk3MTQyOTU5MiIsImlhdCI6MTU3MzMyNzE0MSwiZXhwIjoxNTczMzI4MDQxfQ.6O0CttauYGXElg1KW0J1j-CJR30Xn_FMDCea3qzDQQr4wVme3BklUI_gAvuL3Pb3hP6BvVJS-BOpcZ2A0b94rw");
request.setRequestHeader("Content-Type", "application/json");



request.onload = function () {
    // Begin accessing JSON data here

    var data = JSON.parse(this.response)
    console.log(data)
    data.forEach(doctorJSON => {

        const row = document.getElementById('doctorList')
        
        var image_div = document.createElement('div');
        image_div.setAttribute('class','col-lg-3');

        const info_image = document.createElement('div')
        info_image.setAttribute('class', 'col-lg-3')
        row.appendChild(info_image)
        const about_image = document.createElement('div')
        about_image.setAttribute('class', 'about_image')


        const img = document.createElement('img')
        img.src = "images/about.png";
        about_image.appendChild(img)




        const info = document.createElement('div')
        info.setAttribute('class', 'col-lg-9')
        

        const about_text = document.createElement('div')
        about_text.setAttribute('class', 'about_text')
        

        var doc_name = document.createElement('div')
        doc_name.setAttribute('class', 'doct_title')
        doc_name.textContent = doctorJSON.name;
        about_text.appendChild(doc_name)

        var doc_dept = document.createElement('div')
        doc_dept.setAttribute('class', 'doct_subtitle')
        doc_dept.textContent = doctorJSON.department;
        about_text.appendChild(doc_dept)

        var doc_degree = document.createElement('div')
        doc_degree.setAttribute('class', 'doct_subtitle')
        doc_degree.textContent = doctorJSON.degree;
        about_text.appendChild(doc_degree)
        info.appendChild(about_text)


        var btninfo = document.createElement('div')
        btninfo.setAttribute('class', 'button about_button')
        var aref = document.createElement('a')
        aref.setAttribute('href','doctor_profile.html?id='+doctorJSON.phonenumber);
        aref.textContent = "See Details"
        btninfo.appendChild(aref)

        info.appendChild(btninfo)
        row.appendChild(info)


        var hrr = document.createElement('div');
        hrr.setAttribute('class','doct_line')
        row.appendChild(hrr)


    })
}

// Send request
request.send()





