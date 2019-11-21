var request = new XMLHttpRequest()

// Open a new connection, using the GET request on the URL endpoint
request.open('GET', 'http://localhost:8181/api/get-prescrption/01971429592', true)
request.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwMTk3MTQyOTU5MiIsImlhdCI6MTU3MzMyNzE0MSwiZXhwIjoxNTczMzI4MDQxfQ.6O0CttauYGXElg1KW0J1j-CJR30Xn_FMDCea3qzDQQr4wVme3BklUI_gAvuL3Pb3hP6BvVJS-BOpcZ2A0b94rw");

request.onload = function () {
    // Begin accessing JSON data here

    var data = JSON.parse(this.response)
    console.log(data)
    data.forEach(prescriptionJSON => {

        const app = document.getElementById('prescriptionList')
        const col = document.createElement('div')
        col.setAttribute('class', 'col-lg-3 col-md-6 doct_col')
        app.appendChild(col)
        const fullLink = document.createElement('a')

        var strLink = "#"
        fullLink.setAttribute("href", strLink)
        col.appendChild(fullLink)

        const prescription = document.createElement('div')
        prescription.setAttribute('class', 'doct')
        fullLink.appendChild(prescription)

        const prescriptionImage = document.createElement('div')
        prescriptionImage.setAttribute('class', 'doct_image')

        const img = document.createElement('img')
        img.src = prescriptionJSON.image
        prescriptionImage.appendChild(img)

        prescription.appendChild(prescriptionImage);

        const prescription_content = document.createElement('div')
        prescription_content.setAttribute('class', 'doct_content text-center')
        prescription_content.style.backgroundColor = "#726d6d"
        prescription.appendChild(prescription_content)

        const prescription_title = document.createElement('div')
        prescription_title.setAttribute('class', 'doct_title')
        prescription_content.appendChild(prescription_title)

        const prescription_subtitle = document.createElement('div')
        prescription_subtitle.setAttribute('class', 'doct_subtitle')
        prescription_content.appendChild(prescription_subtitle)

        const prescription_subtitle1 = document.createElement('div')
        prescription_subtitle1.setAttribute('class', 'doct_subtitle')
        prescription_content.appendChild(prescription_subtitle1)

    })
}

// Send request
request.send()


