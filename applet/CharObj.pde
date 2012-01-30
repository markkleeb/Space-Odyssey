class CharObj {
  char charStr;
  float x, y, z, xD, yD, zD;
  int fontSize;
  PFont font;
  boolean enabled = false;

  CharObj(char _charStr, float _xD, float _yD, float _zD) {
    charStr = _charStr;
    xD= _xD;
   yD = _yD;
   zD = _zD;
   font = loadFont("AndaleMono-48.vlw");
   fontSize = 18;
    
  }

void start(){
 x = 0;
y = 0;
z = 0;

 enabled = true;
  
}

void charDraw(){
  textFont(fontA);
  fill(255);
  textSize(fontSize);
  text(charStr, x, y, z);
  x += xD;
  y += yD;
  z += zD;

}


}
