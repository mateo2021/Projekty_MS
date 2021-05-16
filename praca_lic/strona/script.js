//obsługa elementów wjazdowych 2 lewo 1 prawo
$(document).on("scroll", function() {
  const windowHeight = $(window).height();
  const scrollValue = $(this).scrollTop();

  const $art2 = $(".art2");
  const $art1 = $(".art1");
  const $art3 = $(".art3");

  const art2FromTop = $art2.offset().top;
  const art2Height = $art2.outerHeight();

  const art1FromTop = $art1.offset().top;
  const art1Height = $art1.outerHeight();

  const art3FromTop = $art3.offset().top;
  const art3Height = $art3.outerHeight();

  if (scrollValue > art2FromTop + art2Height / 2 - windowHeight) {
    $art2.addClass("active");
  }
  if (scrollValue > art1FromTop + art1Height / 2 - windowHeight) {
    $art1.addClass("active");
  }
  if (scrollValue > art3FromTop + art3Height / 2 - windowHeight) {
    $art3.addClass("active");
  }
  // czysciciel
  if (scrollValue < 100) {
    $("article").removeClass("active");
  }
});
// sekcja 2 obwody pojawienie sie
$(document).on("scroll", function() {
  const windowHeight = $(window).height();
  const scrollValue = $(this).scrollTop();

  const $art4 = $(".art4 img");
  const $art5 = $(".art5 img");
  const $art6 = $(".art6 img");

  const art4FromTop = $art4.offset().top;
  const art4Height = $art4.outerHeight();

  const art5FromTop = $art5.offset().top;
  const art5Height = $art5.outerHeight();

  const art6FromTop = $art6.offset().top;
  const art6Height = $art6.outerHeight();

  if (scrollValue > art4FromTop + art4Height / 8 - windowHeight) {
    $art4.addClass("active");
  }
  if (scrollValue > art5FromTop + art5Height / 8 - windowHeight) {
    $art5.addClass("active");
  }
  if (scrollValue > art6FromTop + art6Height / 8 - windowHeight) {
    $art6.addClass("active");
  }
});

// dojazd do sekcji

$(".infos").on("click", function(e) {
  e.preventDefault();
  $("body , html").animate(
    {
      scrollTop: $(".s1").offset().top - 20 + "px"
    },
    1000
  );
});

$(".areas").on("click", function(e) {
  e.preventDefault();
  $("body , html").animate(
    {
      scrollTop: $(".s2").offset().top - 20 + "px"
    },
    1250
  );
});

$(".members").on("click", function(e) {
  e.preventDefault();
  $("body , html").animate(
    {
      scrollTop: $(".s3").offset().top - 20 + "px"
    },
    1500
  );
});

$(".famouses").on("click", function(e) {
  e.preventDefault();
  $("body , html").animate(
    {
      scrollTop: $(".s4").offset().top - 20 + "px"
    },
    1500
  );
});

$(document).on("scroll", function() {
  const scrollValues = $(this).scrollTop();

  if (scrollValues > 2000) {
    $(".btn1").addClass("active");
  }
  if (scrollValues < 2000) {
    $(".btn1").removeClass("active");
  }
});

//powrot do poczatku

$(function() {
  $(".btn1").click(function(e) {
    e.preventDefault();
    $("html, body").animate(
      {
        scrollTop: 0
      },
      1500
    );
  });
});
