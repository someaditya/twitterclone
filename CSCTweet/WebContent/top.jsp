<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="com.twitter.DAO.ProfileDetailsDAO,com.twitter.details.ProfileDetailsBean, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.twitter.DAO.*"%>

   <%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>

<title>Untitled</title>
<meta name="generator" content="Web Page Maker">
<link href="http://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet" type="text/css">

<style type="text/css">


 
.clearfix:after {
    display:block;
    clear:both;
}
 
/*----- Menu Outline -----*/
.menu-wrap {
    width:100%;
    box-shadow:0px 1px 3px rgba(0,0,0,0.2);
    background:#3e3436;
}
 
.menu {
    width:1000px;
    margin:0px auto;
}
 
.menu li {
    margin:0px;
    list-style:none;
    font-family:'Ek Mukta';
}
 
.menu a {
    transition:all linear 0.15s;
    color:#919191;
}
 
.menu li:hover > a, .menu .current-item > a {
    text-decoration:none;
    color:#be5b70;
}
 
.menu .arrow {
    font-size:11px;
    line-height:0%;
}
 
/*----- Top Level -----*/
.menu > ul > li {
    float:left;
    display:inline-block;
    position:relative;
    font-size:19px;
}
 
.menu > ul > li > a {
    padding:10px 40px;
    display:inline-block;
    text-shadow:0px 1px 0px rgba(0,0,0,0.4);
}
 
.menu > ul > li:hover > a, .menu > ul > .current-item > a {
    background:#2e2728;
}
 
/*----- Bottom Level -----*/
.menu li:hover .sub-menu {
    z-index:1;
    opacity:1;
}
 
.sub-menu {
    width:160%;
    padding:5px 0px;
    position:absolute;
    top:100%;
    left:0px;
    z-index:-1;
    opacity:0;
    transition:opacity linear 0.15s;
    box-shadow:0px 2px 3px rgba(0,0,0,0.2);
    background:#2e2728;
}
 
.sub-menu li {
    display:block;
    font-size:16px;
}
 
.sub-menu li a {
    padding:10px 30px;
    display:block;
}
 
.sub-menu li a:hover, .sub-menu .current-item a {
    background:#3e3436;
}
/*----------Text Styles----------*/
.ws6 {font-size: 8px;}
.ws7 {font-size: 9.3px;}
.ws8 {font-size: 11px;}
.ws9 {font-size: 12px;}
.ws10 {font-size: 13px;}
.ws11 {font-size: 15px;}
.ws12 {font-size: 16px;}
.ws14 {font-size: 19px;}
.ws16 {font-size: 21px;}
.ws18 {font-size: 24px;}
.ws20 {font-size: 27px;}
.ws22 {font-size: 29px;}
.ws24 {font-size: 32px;}
.ws26 {font-size: 35px;}
.ws28 {font-size: 37px;}
.ws36 {font-size: 48px;}
.ws48 {font-size: 64px;}
.ws72 {font-size: 96px;}
.ws200 {font-size: 19px;}
.ws201 {font-size: 21px;}
.wpmd {font-size: 13px;font-family: Arial,Helvetica,Sans-Serif;font-style: normal;font-weight: normal;}
/*----------Para Styles----------*/
DIV,UL,OL /* Left */
{
 margin-top: 0px;
 margin-bottom: 0px;
}
</style>

<style type="text/css">
a.style1:link{color:#FFFFFF;text-decoration: none;}
a.style1:visited{color:#FFFFFF;text-decoration: none;}
a.style1:hover{color:#FFFFFF;text-decoration: none;}
a.style1:active{color:#FFFFFF;text-decoration: none;}
</style>

<style type="text/css">
div#container
{
	position:relative;
	width: 1142px;
	margin-top: 0px;
	margin-left: auto;
	margin-right: auto;
	text-align:left; 
}
body {text-align:center;margin:0}
</style>
    <style type="text/css">
  label[for="user_id"] {
    color: red;
  }
</style>
 <style type="text/css">
.myButton {
	background-color:#101411;
	-moz-border-radius:17px;
	-webkit-border-radius:17px;
	border-radius:17px;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:11px 35px;
	text-decoration:none;
	text-shadow:0px 0px 15px #2f6627;
}
.myButton:hover {
	background-color:#000000;
}
.myButton:active {
	position:relative;
	top:1px;
}
.myButton2 {
	background-color:#e31212;
	-moz-border-radius:17px;
	-webkit-border-radius:17px;
	border-radius:17px;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:11px 35px;
	text-decoration:none;
	text-shadow:0px 0px 15px #2f6627;
}
.myButton2:hover {
	background-color:#e31212;
}
.myButton2:active {
	position:relative;
	top:1px;
}
.tweetbutton {
	background-color:black;
	-moz-border-radius:18px;
	-webkit-border-radius:18px;
	border-radius:18px;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:6px 24px;
	text-decoration:none;
	text-shadow:0px 0px 15px #2f6627;
}
.tweetbutton:hover {
	background-color:#000000;
}
.tweetbutton:active {
	position:relative;
	top:1px;
}
.searchbutton {
	background-color:#ffffff;
	-moz-border-radius:18px;
	-webkit-border-radius:18px;
	border-radius:18px;
	display:inline-block;
	cursor:pointer;
	color:#000000;
	font-family:Arial;
	font-size:13px;
	font-weight:bold;
	font-style:italic;
	padding:2px 15px;
	text-decoration:none;
	text-shadow:0px 0px 15px #2f6627;
}
.searchbutton:hover {
	background-color:#e31212;
}
.searchbutton:active {
	position:relative;
	top:1px;
}

   
   </style>     
</head>
<body bgColor="white">
