var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');

canvas.width = window.innerWidth - 10;
canvas.height = window.innerHeight - 10;


// 캐릭터 관련 함수
// character_sun - 주인공 캐릭터
let character_sun_image = new Image();
character_sun_image.src = 'resources/GameResources/myHome.png';
let character_sun_unit = {
    x : 10,
    y : 400,
    width : 20,
    height : 20,
    draw() {
        // ctx.fillStyle = 'green';
        // ctx.fillRect(this.x,this.y, this.width,this.height);
        ctx.drawImage(character_sun_image, this.x, this.y);
    }
}
// character_mother - 어머니 캐릭터
let character_mother_image = new Image();
character_mother_image.src = 'resources/GameResources/mother.png';
let character_mother_unit = {
    x : 400,
    y : 400,
    width : 20,
    height : 20,
    draw() {
        // ctx.fillStyle = 'red';
        // ctx.fillRect(this.x,this.y, this.width,this.height);
        ctx.drawImage(character_mother_image, this.x, this.y);
    }
}
// 구름캐릭터
let character_cloud_image = new Image();
character_cloud_image.src = 'resources/GameResources/Cloud.png';
let character_cloud_unit = {
    draw() {
        ctx.drawImage(character_cloud_image, 65, 390);
    }
}
// 게임 배경 이미지 함수
// 노트북 닫은 상태의 아들 그림
let NotebookClose1 = new Image();
NotebookClose1.src = 'resources/GameResources/NotebookClose.jpg';
ctx.drawImage(NotebookClose1, 10, 10);
let NotebookClose2 = {
    x : 1,
    y : 1,
    draw() {
        ctx.drawImage(NotebookClose1, this.x, this.y);
    }
}
// 노트북을 보고 있는 상태의 아들 그림
let NotebookOn1 = new Image();
NotebookOn1.src = 'resources/GameResources/NotebookOn.jpg';
ctx.drawImage(NotebookOn1, 10, 10);
let NotebookOn2 = {
    x : 1,
    y : 1,
    draw() {
        ctx.drawImage(NotebookOn1, this.x, this.y);
    }
}
// 노트북을 닫은 상태에서 어머니가 들어온 그림
let encounterWithClose1 = new Image();
encounterWithClose1.src = 'resources/GameResources/encounterWithClose.jpg';
ctx.drawImage(encounterWithClose1, 10, 10);
let encounterWithClose2 = {
    x : 1,
    y : 1,
    draw() {
        ctx.drawImage(encounterWithClose1, this.x, this.y);
    }
}
// 노트북을 보고있는 상태에서 어머니에게 걸린 그림
let encounterWithOn1 = new Image();
encounterWithOn1.src = 'resources/GameResources/encounterWithOn.jpg';
ctx.drawImage(encounterWithOn1, 10, 10);
let encounterWithOn2 = {
    x : 1,
    y : 1,
    draw() {
        ctx.drawImage(encounterWithOn1, this.x, this.y);
    }
}

// 점수 함수
let scoreNow = 0;    //페이지 변수 설정    
function scroeUp() {
    scoreNow++;
  document.getElementById("scorez").innerHTML = scoreNow;
}

// 어머니가 집에 도착했을때 상황
function ArriveMother(character_sun_unit, character_mother_unit) {
    let xSub = character_mother_unit.x - (character_sun_unit.x + character_sun_unit.width);
    if (xSub < 0) {
        if(LookScreen) {
        encounterWithOn2.draw();
        scoreNow = scoreNow - 300;
        document.getElementById("scorez").innerHTML = scoreNow;
        cancelAnimationFrame(animation);
        setTimeout(function() {nextGame();}, 4500);
        }
        else {
        encounterWithClose2.draw();
        cancelAnimationFrame(animation);
        setTimeout(function() {nextGame();}, 4500);
        }
    }
}

// 애니메이션 함수
let animation1;
function frameStart1() {
    animation = requestAnimationFrame(frameStart1);    
    // 애니메이션 잔상 삭제
    ctx.clearRect(0,0, canvas.width, canvas.height);
    // 어머니가 진격하는 속도. 소숫점 단위의 값 적용가능
    character_mother_unit.x-= 1;
    character_mother_unit.draw();    
    character_sun_unit.draw();
    NotebookClose2.draw();
    if(LookScreen == true) {
        NotebookOn2.draw();
        scroeUp();
    }
    else {
        NotebookClose2.draw();
    }
    ArriveMother(character_sun_unit,character_mother_unit);
}
let animation2;
function frameStart2() {
    animation = requestAnimationFrame(frameStart2);
    // 애니메이션 잔상 삭제
    ctx.clearRect(0,0, canvas.width, canvas.height);    
    // 어머니가 진격하는 속도. 소숫점 단위의 값 적용가능
    character_mother_unit.x-= 1;
    character_mother_unit.draw();    
    ctx.drawImage(character_cloud_image, 20, 390);
    character_sun_unit.draw();
    NotebookClose2.draw();
    if(LookScreen == true) {
        NotebookOn2.draw();
        scroeUp();
    }
    else {
        NotebookClose2.draw();
    }
    ArriveMother(character_sun_unit,character_mother_unit);
}
let animation3;
function frameStart3() {
    animation = requestAnimationFrame(frameStart3);
    // 애니메이션 잔상 삭제
    ctx.clearRect(0,0, canvas.width, canvas.height);
    // 어머니가 진격하는 속도. 소숫점 단위의 값 적용가능
    character_mother_unit.x-= 1;
    character_mother_unit.draw();
    ctx.drawImage(character_cloud_image, 20, 390);
    ctx.drawImage(character_cloud_image, 50, 390);
    ctx.drawImage(character_cloud_image, 80, 390);
    ctx.drawImage(character_cloud_image, 110, 390);
    character_sun_unit.draw();
    NotebookClose2.draw();
    if(LookScreen == true) {
        NotebookOn2.draw();
        scroeUp();
    }
    else {
        NotebookClose2.draw();
    }
    ArriveMother(character_sun_unit,character_mother_unit);
}
let animation4;
function frameStart4() {
    animation = requestAnimationFrame(frameStart4);
    // 애니메이션 잔상 삭제
    ctx.clearRect(0,0, canvas.width, canvas.height);
    // 어머니가 진격하는 속도. 소숫점 단위의 값 적용가능
    character_mother_unit.x-= 1;
    character_mother_unit.draw();
    ctx.drawImage(character_cloud_image, 20, 390);
    ctx.drawImage(character_cloud_image, 50, 390);
    ctx.drawImage(character_cloud_image, 80, 390);
    ctx.drawImage(character_cloud_image, 110, 390);
    ctx.drawImage(character_cloud_image, 140, 390);
    ctx.drawImage(character_cloud_image, 170, 390);
    ctx.drawImage(character_cloud_image, 200, 390);
    character_sun_unit.draw();
    NotebookClose2.draw();
    if(LookScreen == true) {
        NotebookOn2.draw();
        scroeUp();
    }
    else {
        NotebookClose2.draw();
    }
    ArriveMother(character_sun_unit,character_mother_unit);
}


// 조작키 관련 함수
// let LookScreen = false;
// document.addEventListener('keydown',function(e){
//     // 스페이스바 입력
//     if (e.code === 'Space') {
//         LookScreen = !LookScreen;
//     }
// })

// 조작키 관련 함수 (마우스 왼쪽클릭 시)
let LookScreen = false;
document.addEventListener('mousedown',function(e){
    LookScreen = !LookScreen;
})

// 게임 시작
frameStart1();
// 스크롤바 제거
document.body.style.overflow = "hidden";


// 스테이지 구성
let ThisStage = 1;
function nextGame() {    
    if(ThisStage == 1) {
        ThisStage++;
        character_mother_unit.x = 400;
        character_mother_unit.y = 400;
        character_mother_unit.draw();
        LookScreen = false;
        frameStart2();
    }
    else if(ThisStage == 2) {
        ThisStage++;
        character_mother_unit.x = 400;
        character_mother_unit.y = 400;
        character_mother_unit.draw();
        LookScreen = false;
        frameStart3();
    }
    else if(ThisStage == 3) {
        ThisStage++;
        character_mother_unit.x = 400;
        character_mother_unit.y = 400;
        character_mother_unit.draw();
        LookScreen = false;
        frameStart4();
    }
    else {
        document.write("<span style='font-size : xx-large'>" + "당신의 점수 : " + scoreNow + "</span>");
    }
}
// 명령어 모음

