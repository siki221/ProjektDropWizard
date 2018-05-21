<!DOCTYPE html>
<html>
<title>All data</title>

<head>
<style>

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: center;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}
table {
color: #333;
font-family: Helvetica, Arial, sans-serif;
width: 640px;
border-collapse:
collapse; border-spacing: 0;
}

td, th {
border: 1px solid transparent; /* No more visible border */
height: 30px;
transition: all 0.3s; /* Simple transition for hover effect */
}

th {
background: #DFDFDF; /* Darken header a bit */
font-weight: bold;
}

td {
background: #FAFAFA;
text-align: center;
}

/* Cells in even rows (2,4,6...) are one color */
tr:nth-child(even) td { background: #F1F1F1; }

/* Cells in odd rows (1,3,5...) are another (excludes header cells) */
tr:nth-child(odd) td { background: #FEFEFE; }
</style>



</head>
<body>

<ul>
  <li><a href="/devices">Devices</a></li>
  <li><a href="/data">Available data</a></li>
  <li><a href="/user">Users</a></li>


  </li>
</ul>
<center>



<#list datas>
  <table>
<tr>
<td><b>Date</b></td>
<td><b>Data</b></td>
<td><b>Device</b></td>
<td><b>Info</b></td>

</tr>
    <#items as data>
        <tr>
        <td>${data.date}</td>
        <td>${data.data}</td>
        <td>${data.device}</td>
        <td>${data.info}</td>
        </tr>

    </#items>
  </table>
<#else>
  <p>No data
</#list> 
</center>

</body>
</html>

