/*
This is a saw-wave oscillator. The method .play() starts the oscillator. There
are several setters like .amp(), .freq(), .pan() and .add(). If you want to set all of them at
the same time use .set(float freq, float amp, float add, float pan)
*/

import processing.sound.*;

SqrOsc sqr;

void setup() {
    size(640,360);
    background(255);
    
    // Create and start the sine oscillator.

    sqr = new SqrOsc(this);
    
    //Start the Sine Oscillator. There will be no sound in the beginning
    //unless the mouse enters the   
    sqr.play();
}

void draw() {
    // Map mouseY from 0.0 to 1.0 for amplitude
    sqr.amp(map(mouseY, 0, height, 1.0, 0.0));

    // Map mouseX from 20Hz to 1000Hz for frequency  
    sqr.freq(map(mouseX, 0, width, 80.0, 200.0));
  
    // Map mouseX from -1.0 to 1.0 for left to right 
    sqr.pan(map(mouseX, 0, width, -1.0, 1.0));
}
