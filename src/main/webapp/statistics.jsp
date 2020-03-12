<!-- Reference: https://stackoverflow.com/questions/31703396/d3-pie-chart-element-popout/31706125#31706125 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<script src="http://d3js.org/d3.v3.min.js"></script>
	<meta charset="utf-8">
	<title>Module Enrolment</title>
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>

<center>
	<h1>Statistics</h1>
	<br /><br /><br />
	<h3>
		<a href="/welcome">Back to Home Page</a> &nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/listAllEnroledModules">View Available Modules</a> &nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/listActiveEnrolledModules">View Current Modules</a>
	</h3>
	</br> </br><br />
<div id="content">
	<h3>Nationalities</h3>
	<br />
	<p>The following data represents the nationalities of students:</p><br />

	<c:forEach items="${nationalitiesMap}" var="entry">
	${entry.value.size()} from ${entry.key} <br>
	</c:forEach>

</br> </br> </br>
	<h3>Gender</h3>
	<br />
	<p>The following pie chart represents the number of male vs female students:</p>
	<br /><br/>
	<script type="text/javascript">
		var w = 300, //width
				h = 300, //height
				r = 100, //radius
				color = d3.scale.category20c(); //builtin range of colors

		data = [ {
			"label" : "Male",
			"value" : ${males}
		}, {
			"label" : "Female",
			"value" : ${femals}
		} ];

		var vis = d3.select("body").append("svg:svg") .attr('transform', 'translate(375,20)')//create the SVG element inside the <body>
				.data([ data ]) //associate our data with the document
				.attr("width", w) //set the width and height of our visualization (these will be attributes of the <svg> tag
				.attr("height", h).append("svg:g") //make a group to hold our pie chart
				.attr("transform", "translate(" + r + "," + r + ")") //move the center of the pie chart from 0, 0 to radius, radius

		var arc = d3.svg.arc() //this will create <path> elements for us using arc data
				.outerRadius(r);

		var pie = d3.layout.pie() //this will create arc data for us given a list of values
				.value(function(d) {
					return d.value;
				}); //we must tell it out to access the value of each element in our data array

		var arcs = vis.selectAll("g.slice") //this selects all <g> elements with class slice (there aren't any yet)
				.data(pie) //associate the generated pie data (an array of arcs, each having startAngle, endAngle and value properties)
				.enter() //this will create <g> elements for every "extra" data element that should be associated with a selection. The result is creating a <g> for every object in the data array
				.append("svg:g") //create a group to hold each slice (we will have a <path> and a <text> element associated with each slice)
				.attr("class", "slice"); //allow us to style things in the slices (like text)

		arcs.append("svg:path").attr("fill", function(d, i) {
			return color(i);
		}) //set the color for each slice to be chosen from the color function defined above
				.attr("d", arc); //this creates the actual SVG path using the associated data (pie) with the arc drawing function

		arcs.append("svg:text") //add a label to each slice
				.attr("transform", function(d) { //set the label's origin to the center of the arc
					//we have to make sure to set these before calling arc.centroid
					d.innerRadius = 0;
					d.outerRadius = r;
					return "translate(" + arc.centroid(d) + ")"; //this gives us a pair of coordinates like [50, 50]
				}).attr("text-anchor", "middle") //center the text on it's origin
				.text(function(d, i) {
					return data[i].label;
				}); //get the label from our original data array
	</script>

</div>



</center>
</body>
</html>
