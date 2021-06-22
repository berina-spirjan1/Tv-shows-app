# TOP RATED TV SHOWS AND MOVIES APP
<br>

## Introduction
<br>
<p> At a time when many people's lifestyle has forced to change their lifestyle overnight, they found refuge by watching various television shows, movies, etc. That is why we bring you an application that will make it easier for you to choose movies and TV series, and bring a summary of the action. This project is based on the development of an Android mobile application using the modern Kotlin programming language. To ensure proper use of your application is to have an internet connection, and to download the files located at the top of your browser. Of course, in order to run a given application, it is necessary to have a configured program to run your application, such as Android Studio.
In this Popcornflix app the user can choose two options, movie search or tv series. If the user wants to read or view the details of another movie or series, this is also enabled, it is only necessary to select the appropriate category for that data filtering.</p>
<img src="https://github.com/berina-spirjan1/Tv-shows-app/blob/main/images/image1.jpg" alt="Image of application icon" width="100" height="100"  ALIGN=”left” >
 <br><hr>

## Project objective
<p>Development of an Android application that can complete free time from the youngest to the oldest, who are in doubt about which category to choose or threaten to summarize a good movie or TV series.</p>
<br>
<p>In the following, we will briefly introduce you to the architecture of the application, where we will explain in detail the functionality of the database, retrofit, fragments, activities, etc.</p>
<br><hr>

## Application architecture

<p>The idea of using a certain architecture in the development of this mobile application is to enable the design of the application in such way that its growth doesn't complicate the process of maintaining, adding new functionalities or changing existing ones. The use of architecture involves making a series of decisions, based on various factors, taking into account the need to meet all technical and functional requirements, but at the same time try to optimize features such as: performance, security, upgradeability, maintenance and the like.</p>

<p>The architecture of this application belongs to the multilayer, because it has three levels: <ul>
 <li>the presentation layer,</li><li> the business logic layer and</li> <li>the data access layer.</li></ul></p>
 <br><hr>
 
 ## Directory of Dependency injection or abbreviated "di"
 
 <p>Hilt is built on top of the popular DI Dagger library, so it benefits from the correctness of compilation time, performance, scalability, and support for Android Studio provided by Dagger. In the directory of this name we placed two objects <b>NetworkObject</b> and <b>RepositoryObject</b>. We called the object <b>NetworkObject</b> to group the logic of providing objects related to networking. Similarly, we create a <b>RepositoryObject</b> to import a repository from the Web API that we provide in <a href="https://developers.themoviedb.org/3">MovieDB</a>.</p>
<br><hr>

## Models

<p>The model represents the component that is responsible for the data used within the application. This is the so-called The “data access layer” that is most hidden and remote for the user, as it contains entities that manage the database, network requests, and convert data from one form to another so that they are ready to be displayed to the end user. As for the models that we use in our project, they are <b>Movie</b> and <b>MovieResponse</b> that we generate with the help of plugins, for simplicity and speed, and which contain all the data that characterizes a movie, or TV series.</p>
<br><hr>

## Retrofit

<p>Retrofit is a type-safe REST client for Android, Java and Kotlin developed by Square. The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with OkHttp. This directory has two files, one of which is an interface <b>GetDataServer</b>, that declares the method of obtaining the method for our Web API and we publish the creation of a function for searching and adding information about our categories. In addition to the interface, the directory also has a <b>DataClient</b> object in which we connect the api key, which is unique for each user, the url for the database, and the url for retrieving photos.</p>

