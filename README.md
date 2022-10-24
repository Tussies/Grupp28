# Alien Run
Alien Run is a side-scroller platformer game where you play as an alien 
collecting gems while avoiding obstacles. The user can choose one of three
modes to play: Easy, Normal, and Difficult.

##Installation and building
For imports to work correctly, you need to install Java version 17 or under.
The project uses Gradle to build, and only has the dependency libGDX, 
a Java development framework used to code games.
To run the game, go to src > com.grupp28gdx.game > DesktopLauncher
and click on run from there. The following steps are for building this project in Gradle
on the IDE IntelliJ.

###Step 1
Click on Gradle on the right side of the screen, 
a menu consisting of Gradle commands will show up.

###Step 2
Click on directory "other", and then on command "run" after expanding the directory.

##Running tests
To be able to run tests in IntelliJ, click on IntelliJ IDEA > Preferences.
In the Preferences window, press "Build, Execution, Deployment" > "Build Tools" > "Gradle".
In the drop-down menu for "Run tests using:" choose IntelliJ IDEA.
Now it should be able to run tests in IntelliJ!

For running tests, right-click on the "test" directory in IntelliJ and click on "Run Tests in Grupp28.co...".
To get tests with line coverage, hover over "More Run/Debug" and click on "Run All Tests in Grupp28.co... with Coverage".


##Authors and acknowledgment
Atosa Daneshvar-Minabi, Alexander Gilabert, Ann Heijkenskjöld, Isak Wideskott