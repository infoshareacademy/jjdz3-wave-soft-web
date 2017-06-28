<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="myCarousel" class="carousel slide" data-interval="3000" data-ride="carousel">
    <!-- Carousel indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Carousel items -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="images/slide1.png" alt="First Slide">
            <div class="carousel-caption">
                <h3>Z nami znajdziesz części których potrzebujesz, namierzymy to czego szukasz!</h3>
            </div>
        </div>
        <div class="item">
            <img src="images/slide2.png" alt="Second Slide">
            <div class="carousel-caption">
                <h3>Byś sam nie tracił na to czasu!</h3>
            </div>
        </div>
        <div class="item">
            <img src="images/slide3.png" alt="Third Slide">
            <div class="carousel-caption">
                <h3>Tak aby pojazd napawał Cię dumą!</h3>
            </div>
        </div>
    </div>
    <!-- Carousel nav -->
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>