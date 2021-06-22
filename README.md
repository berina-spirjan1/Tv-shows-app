# TOP RATED TV SHOWS AND MOVIES APP
<br>

## Introduction
<br>
<p> At a time when many people's lifestyle has forced to change their lifestyle overnight, they found refuge by watching various television shows, movies, etc. That is why we bring you an application that will make it easier for you to choose movies and TV series, and bring a summary of the action. This project is based on the development of an Android mobile application using the modern Kotlin programming language. To ensure proper use of your application is to have an internet connection, and to download the files located at the top of your browser. Of course, in order to run a given application, it is necessary to have a configured program to run your application, such as Android Studio.
In this Popcornflix app the user can choose two options, movie search or tv series. If the user wants to read or view the details of another movie or series, this is also enabled, it is only necessary to select the appropriate category for that data filtering.</p>
<img src="https://github.com/berina-spirjan1/Tv-shows-app/blob/main/images/image1.jpg" alt="Image of application icon" width="100" height="100"  ALIGN=”center” >
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

<p>Retrofit is a type-safe REST client for Android, Java and Kotlin developed by Square. The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with OkHttp. This directory has two files, one of which is an interface <b>GetDataServer</b>, that declares the method of obtaining the method for our Web API and we publish the creation of a function for searching and adding information about our categories. In addition to the interface, the directory also has a <b>DataClient</b> object in which we connect the api key, which is unique for each user, the url for the database and the url for retrieving photos.</p>
<br><hr>

## Repository

<p>The repository is used to hide the multiple data sources we may have in our application, data in an application may come from an internal database, or, an external service such as a Web API. Our repository has three functions, one of which serves us to gain access with the network, and make a specific request depending on what status we get. The remaining two functions are used to search and retrieve the data we need to operate our application.</p>
<br><hr>

## Adapter

<p>An Adapter object acts as a bridge between an AdapterView and the underlying data for that view. The Adapter provides access to the data items. The Adapter is also responsible for making a View for each item in the data set. In our case, the adapter is a <b>RecyclerAdapter</b> in which we declare the <b>onMovieListClick</b> function, which we will later use to open the list item, in order to get a detailed overview of the data for each element of the list. In addition to this function, we also own a nested class marked as inner can access members of its outer class. The inner classes carry a reference to the outer class object, i.e. the class <b>CategoryViewHolder</b>. We design how each item on the list will look and behave. Based on layout, we extend the <b>ViewHolder</b> class. Our version of <b>ViewHolder</b> provides all the functions for listed items. The carrier of your view is the wrapper around the view, and this view is managed by <b>RecyclerView</b>. </p>
<br><hr>

## ViewModel

<p>ViewModel objects are scoped to the Lifecycle passed to the ViewModelProvider when getting the ViewModel. The ViewModel remains in memory until the Lifecycle it's scoped to goes away permanently: in the case of an activity, when it finishes, while in the case of a fragment, when it's detached. </p>
<br><hr>

## Utility directory

<p>The directory consists of several files: <b>Asserts</b>, <b>DeclarationHelper</b>, <b>SourceAssert</b>. In the following, we will explain the meaning of each one. The class <b>Assert</b> uses us as a class with the help of which we get information about the execution status of some parts of the code. It has an enum class in which we declare three statuses, and with the help of the companion object we enable access to functions that are of the same name as the status types. The class <b>DeclarationHelper</b> allows us to implement the functions we use in the <b>ListFragment</b>, the <b>ImageView.loadMovieUrl</b> function serves us so that we can correctly load poster images of movies and TV series, which are declared to us in the JSON file. The second function is <b>SearchView.onTextChangeWaitListener()</b>, which we use when searching for certain categories and its call is in the <b>ListFragment</b>.</p>
<br><hr>

## Activities
<p>One activity represents one screen with a user interface, performs actions and displays the result on the screen. In the Popcornflix application, we have two activities: <b>EnterActivity</b>, which is linked to the layout <b>activity_enter</b>, with the help of which we create a splash screen. The appearance of this screen is shown in the first photo below this text. The second activity we use is <b>MainActivity</b>, which has <b>layout_main</b>, and this activity is associated with a <b>navigation graph</b> consisting of two fragments: <b>ListFragment</b> and <b>SingleItemCategory</b>.</p>
<img src="https://github.com/berina-spirjan1/Tv-shows-app/blob/main/images/image2.jpg" alt="Image of application icon"  width="250" height="500" ALIGN=”center” >
 <br><hr>
