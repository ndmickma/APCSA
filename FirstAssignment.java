/**
 *	FirstAssignment.java
 *	Display a brief description of your summer vacation on the screen.
 *
 *	To compile Linux:	javac -cp .:mvAcm.jar FirstAssignment.java
 *	To execute Linux:	java -cp .:mvAcm.jar FirstAssignment
 *
 *	To compile MS Powershell:	javac -cp ".;mvAcm.jar" FirstAssignment.java
 *	To execute MS Powershell:	java -cp ".;mvAcm.jar" FirstAssignment
 *
 *	@author	Sanvitti Shah
 *	@since	August 20th, 2026
 */
import java.awt.Font;

import acm.program.GraphicsProgram;
import acm.graphics.GLabel;

public class FirstAssignment extends GraphicsProgram {
    
    /**
	  * Runs all the GLabels that have what I did over summer
	  * @param 				no parameter
	  * @return 			nothing is returned
	  */
    public void run() {
    	//	The font to be used
    	Font f = new Font("Serif", Font.BOLD, 18);
    	
    	//	Line 1
    	GLabel s1 = new GLabel("What I did on my summer vacation ...", 8, 20);
    	s1.setFont(f);
    	add(s1);

    	//	Line 2
    	GLabel s2 = new GLabel("At the start of summer vacation my " + 
			"family and I took a road trip to LA. We had a lot ", 8, 40);
    	s2.setFont(f);
    	add(s2);
    	
    	//	Line 3
    	GLabel s3 = new GLabel("fun during the drive, but my favorite " + 
			"part was definitely the snacks. Out of all of the snacks", 8, 60);
    	s3.setFont(f);
    	add(s3);
    	
    	//	Line 4
    	GLabel s4 = new GLabel("we bought my favorite snack was Goldfish! " + 
			"Once we got to LA, the first place we went was ", 8, 80);
    	s4.setFont(f);
    	add(s4);
    	
    	//	Line 5
    	GLabel s5 = new GLabel("Santa Monica Pier! It was very fun because we got " + 
			"to watch the sunset. It was very beautiful ", 8, 100);
    	s5.setFont(f);
    	add(s5);
    	
    	//	Line 6
    	GLabel s6 = new GLabel("and afterwards we went to get dinner. We " + 
			"had Indian food, it didn't taste amazing, but we ", 8, 120);
    	s6.setFont(f);
    	add(s6);
    	
    	//	Line 7
    	GLabel s7 = new GLabel("were all very hungry so it all worked" + 
			" out! After that, we checked into our hotel, and I ", 8, 140);
    	s7.setFont(f);
    	add(s7);
    	
    	//	Line 8
    	GLabel s8 = new GLabel("watched some TV on my laptop. I watched " + 
			"a movie called The Fantastic Four. It's a great ", 8, 160);
    	s8.setFont(f);
    	add(s8);
    	
    	//	Line 9
    	GLabel s9 = new GLabel("movie! The next day was just as " + 
			"fun! We went to an outdoor mall/food area and we had ", 8, 180);
    	s9.setFont(f);
    	add(s9);
    	
    	//	Line 10
    	GLabel s10 = new GLabel("some delicious ramen! We didn't " + 
			"drive directly home after that day, instead we drove to UC ", 8, 200);
    	s10.setFont(f);
    	add(s10);
    	
    	//	Line 11
    	GLabel s11 = new GLabel("Davis for a summer program! " + 
			"The program was about AI in Food Systems and I had a lot ", 8, 220);
    	s11.setFont(f);
    	add(s11);
    	
    	//	Line 12
    	GLabel s12 = new GLabel("of fun! After, we came back" + 
			" home and stayed home for the rest of the summer. But instead ", 8, 240);
    	s12.setFont(f);
    	add(s12);
    	
    	//	Line 13
    	GLabel s13 = new GLabel("of travelling I did other " + 
			"things with my time. I volunteered!", 8, 260);
    	s13.setFont(f);
    	add(s13);
    	
    	//	Line 14
    	GLabel s14 = new GLabel("The place I volunteered was a summer camp " + 
			"that is run by the City of Cupertino! The specific ", 8, 280);
    	s14.setFont(f);
    	add(s14);
    	
    	//	Line 15
    	GLabel s15 = new GLabel("camp I volunteered at is the " + 
			"preschool, ages 3 to 5. I had a lot of fun and I will " +
			"definitely ", 8, 300);
    	s15.setFont(f);
    	add(s15);
    	
    	//	Line 16
    	GLabel s16 = new GLabel("do it again! Besides volunteering, I was" + 
			" busy planning my 16th birthday party. Although ", 8, 320);
    	s16.setFont(f);
    	add(s16);
    	
    	//	Line 17
    	GLabel s17 = new GLabel("it will be in September I wanted to plan " + 
			"everything before school started. I successfully ", 8, 340);
    	s17.setFont(f);
    	add(s17);
    	
    	//	Line 18
    	GLabel s18 = new GLabel("planned every part of the party, from what" + 
			" the party favors will include, to designing and ", 8, 360);
    	s18.setFont(f);
    	add(s18);
    	
    	//	Line 19
    	GLabel s19 = new GLabel("packaging the invitations! " + 
			"Planning the party was the best part of my summer.", 8, 380);
    	s19.setFont(f);
    	add(s19);
    	
    	//	Line 20
    	GLabel s20 = new GLabel("Overall, this paragraph sums up my " + 
			"summer vacation and I'm so happy with all the ", 8, 400);
    	s20.setFont(f);
    	add(s20);
    	
    	//	Line 21
    	GLabel s21 = new GLabel("memories I made this summer and also" + 
			"all the new experiences this summer!", 8, 420);
    	s21.setFont(f);
    	add(s21);

    }
}
