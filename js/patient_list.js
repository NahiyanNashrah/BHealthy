function generate_table() {

    var list = document.getElementById('patientList');
    var table = document.createElement('table');
    table.style.fontFamily='arial, sans-serif';
    table.style.borderCollapse= 'collapse';
    table.style.width= '100%';
    table.setAttribute('border', '1');
    
    var header = document.createElement('thead');
    var headingRow = document.createElement('tr');
    var headingCell1 = document.createElement('td');
    var headingText1 = document.createTextNode('Serial');
    headingCell1.appendChild(headingText1);
    headingRow.appendChild(headingCell1);
    
    
    var headingCell2 = document.createElement('td');
    var headingText2 = document.createTextNode("patient's Name");
    headingCell2.appendChild(headingText2);
    headingRow.appendChild(headingCell2);
    
    
    var headingCell3 = document.createElement('td');
    var headingText3 = document.createTextNode("View Prescription");
    headingCell3.appendChild(headingText3);
    headingRow.appendChild(headingCell3);
    
    
    header.appendChild(headingRow);
    table.appendChild(header);

    // get the reference for the body
    // var body = document.getElementById('patientList');

    // // creates a <table> element and a <tbody> element
    // var tbl = document.createElement("table");
    // //var header = document.createElement("header");
    // // var header = '<tr><th>Country</th><th>City</th></tr>';
    // var header=  document.createElement('thead')
    // var headingRow = document.createElement('tr')

    // var headingCell1 = document.createElement('td')
    // var headingText1 = document.createTextNode('Serial')
    // headingCell1.appendChild(headingText1)
    // headingRow.appendChild(headingCell1)
    
    // var headingCell2 = document.createElement('td')
    // var headingText2 = document.createTextNode('Name')
    // headingCell2.appendChild(headingText2)
    // headingRow.appendChild(headingCell2)

    // header.appendChild(headingRow)
    // tbl.appendChild(header)
    //var header = "<th>Header</th>";
    var tblBody = document.createElement("tbody");


    // creating all cells
    for (var i = 0; i < 5; i++) {
        // creates a table row
        var row = document.createElement("tr");

        for (var j = 0; j < 3; j++) {
            // Create a <td> element and a text node, make the text
            // node the contents of the <td>, and put the <td> at
            // the end of the table row
            var cell = document.createElement("td");
            if (j == 0) {
                var cellText = document.createTextNode(i+" "+j);
            } else {
                var cellText = document.createTextNode(i+" "+j);
            }


            cell.appendChild(cellText);
            row.appendChild(cell);
        }

        // add the row to the end of the table body
        tblBody.appendChild(row);
    }
    // This is for the quick solution
    // tbl.innerHTML = header

    // put the <tbody> in the <table>
   // tbl.appendChild(tblBody);

    table.appendChild(tblBody);

    list.appendChild(table);

    // appends <table> into <body>
   // body.appendChild(tbl);
    // sets the border attribute of tbl to 2;
    //tbl.setAttribute("border", "2");
}

generate_table()