let p1imgsrc = "./image/trashbag1.jpg"; 
let p2imgsrc = "./image/trashbag2.jpg"; 
let p3imgsrc = "./image/trashbag3.jpg";
let p1name ="Usada Pekora";
let p2name ="Houshou Marine";
let p3name ="Shirogane Noel";
let p1content ="pekopekopeko!";
let p2content ="ERO GAKI!";
let p3content ="neolneol!";
let p1price =20;
let p2price =50;
let p3price =100;
let plink = "product.html";
const p1btn = $('.product1 a');
const p2btn = $('.product2 a');
const p3btn = $('.product3 a');

$('.product1 img').attr('src',p1imgsrc);
$('.product2 img').attr('src',p2imgsrc);
$('.product3 img').attr('src',p3imgsrc);
$('.product1 .card-title').text(p1name);
$('.product2 .card-title').text(p2name);
$('.product3 .card-title').text(p3name);
$('.product1 .card-content').text(p1content);
$('.product2 .card-content').text(p2content);
$('.product3 .card-content').text(p3content);
$('.product1 .price').text(p1price+"元");
$('.product2 .price').text(p2price+"元");
$('.product3 .price').text(p3price+"元");
$('.spl').attr('href',plink);


p1btn.click(()=>{
    let splink=[];

    splink.push({
        p_imgsrc  :   p1imgsrc,
        p_name    :   p1name,
        p_content :   p1content,
        p_price   :   p1price,
    });
    sessionStorage.setItem('splink',JSON.stringify(splink));
});
p2btn.click(()=>{
    let splink=[];

    splink.push({
        p_imgsrc  :   p2imgsrc,
        p_name    :   p2name,
        p_content :   p2content,
        p_price   :   p2price,
    });
    sessionStorage.setItem('splink',JSON.stringify(splink));
});
p3btn.click(()=>{
    let splink=[];

    splink.push({
        p_imgsrc  :   p3imgsrc,
        p_name    :   p3name,
        p_content :   p3content,
        p_price   :   p3price,
    });
    sessionStorage.setItem('splink',JSON.stringify(splink));
});
