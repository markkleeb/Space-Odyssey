class Phrase {

  float xspeed;
  float yspeed;
  float zspeed;
  String phrase;
  CharObj letter[];
  boolean enabled = false;
  int  frameNumber = 8;
  int incrementer = 0;

  Phrase(String _phrase) {

    zspeed = -1;
    phrase = _phrase;
    letter = new CharObj[phrase.length()];

    for (int i = 0; i < phrase.length(); i++) {

      letter[i] = new CharObj(phrase.charAt(i), xspeed, yspeed, zspeed);
    }
  }

  void start() {
    xspeed = random(-5, 5);
    yspeed = random(1, 5);
    for (int i = 0; i < phrase.length(); i++) {

      letter[i] = new CharObj(phrase.charAt(i), xspeed, yspeed, zspeed);
    }
    enabled = true;
    incrementer = 0;
  }
  void drawPhrase() {
    if ((incrementer % frameNumber == 0) && (incrementer / frameNumber < letter.length)) {
      int charNum = incrementer / frameNumber;
      letter[charNum].start();
      println("Character " + letter[charNum].charStr + " enabled");
    }

    for (int i = 0; i < letter.length; i++) {
      if (letter[i].enabled) {
        letter[i].charDraw();
      }
    }

    incrementer++;
  }
}

