<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru">

<head>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Історія</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="/resources/css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="<c:url value="/"/>">Новоселиця</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/"/>">Головна</a>
                </li>
                <c:if test="${pageContext.request.isUserInRole('MANAGER')}">
                <li>
                    <a href="<c:url value="/management"/>">Менеджмент</a>
                </li>
                </c:if>
                <li>
                    <a href="<c:url value="/news"/>">Новини</a>
                </li>
                <li>
                    <a href="<c:url value="/places"/>">Місця</a>
                </li>
                <li>
                    <a href="<c:url value="/history"/>">Історія</a>
                </li>
                <li>
                    <a href="<c:url value="/profile"/>">Профіль</a>
                </li>
                <li>
                    <a href="<c:url value="/contact"/>">Контакти</a>
                </li>
                <li>
                    <a href="<c:url value="/logout"/>">Вийти</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header" style="background-image: url('/images/home_bg.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <h1>Історія</h1>
                    <hr class="small">

                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->

<div class="container">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            <h2 class="section-heading">Історія села Новоселиця</h2>

            <p>Село Новоселиця розкинулося на правому бурезі р. Свічі на північний захід від селища Вигода. Віддаль від села до районного центру- м. Долина - 7 км. Загальна площа 1 066 га. Біля села проходить автомагістраль Долина-Хуст. До Новоселиці прилягають ліс та р. Свіча. Природне різнобарв'я милує око і жителям села і гостям. </p>
            <p>Раніше, як подає Йосифінська метрика - перший поземельний кадастр Галичини (1785 - 1788 р.р.), - на території Долинщини існувало дві Новоселиці - Вижня та Нижня. Нині на топонімічній карті району зафіксовано одне село під такою назвою. Перша письмова згадка про село міститьсяв документі 1657 р. Біля села за Свчею на стрімкій горі, в урочищі "Замчище", колись стояв оборонний дерев'яний замок, що був збудований  у XII ст. князем Острозьким і простояв до кінця XIV ст. Дослідники Бойківщини стверджують, що саме тут, на лівому березі р. Свіча, ще в часи Галицької Русі, була фортифікаційна споруда (залога) - один з оборонних пунктів, де княжі люди стерегли переходи через Карпати. Збереглися сліди цієї давньої споруди, а гора називається Замчище. Сьогодні - це природній заповідник.</p>
            <img class="img-responsive center-block" src="/images/history.jpg" alt="">
            <span class="caption text-muted">Урочище "Замчище"</span>
            <p>На голих скелях урочища ростуть реліктові сосни. На вершині гори Замчище в різні часи люди знаходили всякі старожитності. Урочище "Осій" (гірський хребет, на якому височить гора Замчище) багате на залізну руду. Поклади руди є і на самій горі Замчище. Її в давнину тут добували та плавили в печах. За давніми перекладами шість плавильних печей розміщувалися на Дарваєвому березі.</p>
            <img class="img-responsive center-block" src="/images/osii.jpg" alt="">
            <span class="caption text-muted">Урочище "Осій"</span>
            <p>Князь Острозький побудував замок для охорони дороги з Галицько-Волинського князівства на угри (тепер Угорщина). Сьогодні ця дорога йде через Вигоду на Вишківський та Торунський перевали. Замок слугував кордонною заставою Галицько-Волинського князівства на межі з уграми, що дозволяло контролювати перевал через карпати. Замок на горі Замчище приймав на себе удари вопожих військ. XII-XIII ст. під час походів монголо-татарської орди на західні землі України, замок було зруйновано, а князівське поселення остаточно знищено. Замок князя Острозького проіснував до розпаду Галицько-Волинського князівства наприкінці XIV ст. Тож на підставі історії гори замчище, розташованої на території Новоселиці, можна стверджувати, що виникнення цього селе пов'язане із заснуванням оборонного укріплення, біля якого в давнину селився ремісничий люд.
            А назва села відображає сам факт виникнення нового бйківського поселення.</p>
            <p>1901 р. тут збудували дерев'яну церкву св. Архистратига Михаїла, в якій проводяться богослужіння і по нині. 1914 р. в селі відкрили першу початкову школу в якій навчалося 130 дітей. Першою вчителькою була Люба Іванівна Гулийчук (Мицько). 1935 р. школа була двокласною. В селі також збодували декілька магазинів. В урочищі "Камениця" працював водяний млин. Через село було прокладено залізничну колію та збудовано залізничну станцію. По цій колії їздив потяг із двома вагонами за маршрутом Долина-Вигода. З приходом польської влади в селі збудували тартак, а також мебливий цех, де виготовляли гнуті крісла. В цеху працювали переважно місцеві жителі. Пізніше цех згорів, а фундамент залишився й по нині. 1922 р. поляки спорудили лісозавод, де встановили пилораму. Тут працювали більшість людей з верхньої частини села, а нижня, що називалася Шляхтою, займалася сільським господарством.</p>
            <img class="img-responsive center-block" src="/images/church.jpg" alt="">
            <span class="caption text-muted">Церква св. Архистратига Михаїла</span>
            <p>У період між світовими війнами у селі працювала читальня "Просвіти". Вона поділялася на чоловічу, організатором якої був писар громади Василь Григорович Пилипів, і жіночу частину, яку очолила Параска Семенівна Голуб. Діяли товариство "Січ" та кружок "Сільський господар". Староство і суд знаходились в Долині, пошта і телеграф - у Вигоді.</p>
            <p>Незадовго до проголошення української Незалежності, 1990 р., біля сільської церкви насипали могилу борцям за волю України. Під час її урочистого відкриття присутні почули, що на дні могили покладено капсулу з рефератом, написаним тодішнім головою сільської ради М.І. Голубом. Встановлено обеліск воїнам, що полягли в бою з нацистськими загарбниками. У селі є декілька пам'ятних хрестів. На одному з них, що біля церкви, написано: "Пом'яни, Господи, душі рабів твоїх, громадян Новоселиці, голови свої за Україну поклавших у 1914 - 1919 роках". У списку із 37 осіб є і прізвище невідомого солдата із самбірщини, який загинув у Новоселиці. </p>
            <p>Тепер це успішне село, яке прагне йти в ногу з часом.</p>
        </div>
</div>
<hr>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <ul class="list-inline text-center">
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                </ul>
                <p class="copyright text-muted">Novoselytsia &copy; 2020</p>
            </div>
        </div>
    </div>
</footer>

<!-- jQuery -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="/resources/js/jqBootstrapValidation.js"></script>
<script src="/resources/js/contact_me.js"></script>

<!-- Theme JavaScript -->
<script src="/resources/js/clean-blog.min.js"></script>

</body>
</html>