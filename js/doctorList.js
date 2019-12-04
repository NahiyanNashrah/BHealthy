var request = new XMLHttpRequest()

// Open a new connection, using the GET request on the URL endpoint
request.open('GET', 'http://localhost:8181/api/doctor-list', true)
//request.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwMTk3MTQyOTU5MiIsImlhdCI6MTU3MzMyNzE0MSwiZXhwIjoxNTczMzI4MDQxfQ.6O0CttauYGXElg1KW0J1j-CJR30Xn_FMDCea3qzDQQr4wVme3BklUI_gAvuL3Pb3hP6BvVJS-BOpcZ2A0b94rw");
request.setRequestHeader("Content-Type", "application/json");

request.onload = function () {
    // Begin accessing JSON data here

    var data = JSON.parse(this.response)
    console.log(data)
    data.forEach(doctorJSON => {

        const app = document.getElementById('doctorList')
        const row = document.createElement('div')
        row.setAttribute('class', 'row-lg-eq-height')
        app.appendChild(row)
        const info = document.createElement('div')
        info.setAttribute('class', 'col-lg-7')
        row.appendChild(info)

        const info_content = document.createElement('div')
        info_content.setAttribute('class', 'info_content')
        var doc_name = document.createElement('div')
        doc_name.setAttribute('class','doc_name')
        doc_name.textContent = doctorJSON.name;
        info_content.appendChild(doc_name)

        var doc_dept = document.createElement('div')
        doc_dept.setAttribute('class','doc_dept')
        doc_dept.textContent = doctorJSON.department;
        info_content.appendChild(doc_dept)

        var doc_degree = document.createElement('div')
        doc_degree.setAttribute('class','doc_degree')
        doc_degree.textContent = doctorJSON.degree;
        info_content.appendChild(doc_degree)

        var doc_visiting = document.createElement('div')
        doc_visiting.setAttribute('class','doc_visiting')
        doc_visiting.textContent = doctorJSON.visiting_hour;
        info_content.appendChild(doc_visiting)

        var doc_location = document.createElement('div')
        doc_location.setAttribute('class','doc_location')
        doc_location.textContent = doctorJSON.location;
        info_content.appendChild(doc_location)

        var doc_fees = document.createElement('div')
        doc_fees.setAttribute('class','doc_fees')
        doc_fees.textContent = doctorJSON.fees;
        info_content.appendChild(doc_fees)

        var btninfo = document.createElement('button')
        btninfo.setAttribute('class','info_button')
        btninfo.textContent = "See Details"
        info_content.appendChild(btninfo)
        info.appendChild(info_content)

        const info_image = document.createElement('div')
        info.setAttribute('class', 'col-lg-5')
        info.appendChild(row)

        const doc_Image = document.createElement('div')
        doc_Image.setAttribute('class', 'doct_image')

        const img = document.createElement('img')
        img.src = doctorJSON.image;
        doc_Image.appendChild(img)

        row.appendChild(doc_Image);

        app.appendChild(row)
        var hrr = document.createElement('hr')
        app.appendChild(hrr)

    })
}

// Send request
request.send()





