String space[]  = {
"HAL: Too bad about Frank, isn't it?",
"BOWMAN: Yes, it is.",
"HAL: I suppose you're pretty broken up about it?",
"BOWMAN: Yes. I am.",
"HAL: He was an excellent crew member.",
"HAL: It's a bad break, but it won't substantially affect the mission.",
"BOWMAN: Hal, give me manual hibernation control.",
"HAL: Have you decided to revive the rest of the crew, Dave?"
};
Phrase[] phrases = new Phrase[space.length];
int inc = 0;
PFont fontA;

void setup() {
 

  fontA = loadFont("AndaleMono-48.vlw");

  for (int i = 0; i < space.length; i++) {
    phrases[i] = new Phrase(space[i]);
}
  size(600, 600, P3D);
  background(0);

}

void draw() {
  background(0);
  translate(width/2, height/2);
  rotateX(PI/4);

for(int i = 0; i < phrases.length; i++){
  if (phrases[i].enabled){
   phrases[i].drawPhrase(); 
  }
}
}

   

void mousePressed() {

  phrases[inc].start();
  inc++;
  
  for(int i = 0; i < phrases.length; i++){
    for(int j=0; j < phrases[i].letter.length; j++){
      println(phrases[i].letter[j].charStr);
    }
  }
  if (inc >= phrases.length) {
    inc = 0;
  }
}


