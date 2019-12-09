function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
        vars[key] = value;
    });
    return vars;
}

var url = "http://localhost:8181/api/auth/find-doctor/{department}";


var request = new XMLHttpRequest()

// Open a new connection, using the GET request on the URL endpoint
request.open('GET', url, true)
//request.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwMTk3MTQyOTU5MiIsImlhdCI6MTU3MzMyNzE0MSwiZXhwIjoxNTczMzI4MDQxfQ.6O0CttauYGXElg1KW0J1j-CJR30Xn_FMDCea3qzDQQr4wVme3BklUI_gAvuL3Pb3hP6BvVJS-BOpcZ2A0b94rw");
request.setRequestHeader("Content-Type", "application/json");

request.onload = function () {
    // Begin accessing JSON data here

    var data = JSON.parse(this.response)
    console.log(data)
    data.forEach(doctorJSON => {

        const app = document.getElementById('doctorList')
        const about = document.createElement('div')
        about.setAttribute('class', 'about')
        app.appendChild(about)
        const container = document.createElement('div')
        container.setAttribute('class', 'container')
        about.appendChild(container)
        const row = document.createElement('div')
        row.setAttribute('class', 'row-lg-eq-height')
        container.appendChild(row)

        const info_image = document.createElement('div')
        info_image.setAttribute('class', 'col-lg-3')
        row.appendChild(info_image)
        const about_image = document.createElement('div')
        about_image.setAttribute('class', 'about_image')


        const img = document.createElement('img')
        img.src = doctorJSON.image;
        about_image.appendChild(img)

        info_image.appendChild(about_image);
        row.appendChild(info_image)
        // container.appendChild(row)

        const info = document.createElement('div')
        info.setAttribute('class', 'col-lg-9')
        row.appendChild(info)

        const about_text = document.createElement('div')
        about_text.setAttribute('class', 'about_text')
        info.appendChild(about_text)

        var doc_name = document.createElement('div')
        doc_name.setAttribute('class','doc_name')
        doc_name.textContent = doctorJSON.name;
        about_text.appendChild(doc_name)

        var doc_dept = document.createElement('div')
        doc_dept.setAttribute('class','doc_dept')
        doc_dept.textContent = doctorJSON.department;
        about_text.appendChild(doc_dept)

        var doc_degree = document.createElement('div')
        doc_degree.setAttribute('class','doc_degree')
        doc_degree.textContent = doctorJSON.degree;
        about_text.appendChild(doc_degree)

        var btninfo = document.createElement('button')
        btninfo.setAttribute('class','button about_button')
        btninfo.textContent = "See Details"
        info.appendChild(btninfo)

        const fullLink = document.createElement('a')

        var strLink = "#"
        fullLink.setAttribute("href", strLink)
        btninfo.appendChild(fullLink)
        
        row.appendChild(info)
        about.appendChild(row)
        container.appendChild(row)

        app.appendChild(about)

        var hrr = document.createElement('hr')
        app.appendChild(hrr)


    })
}

// Send request
request.send()





