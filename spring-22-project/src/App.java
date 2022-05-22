import java.lang.Math;
import java.util.ArrayList;

import medianProblem.*;
public class App {
    public static void main(String[] args){
        System.out.println(System.nanoTime());

        Operators operator = new Operators();
        double[][] facs_coordinates = operator.createDistanceMatrix(5,2);
        double[][] points_coordinates = operator.createDistanceMatrix(20,2);
        Facility[] facs = new Facility[5];
        Point[] points = new Point [20];
        for (int i=0; i<facs.length;i++){
            Facility f1 = new Facility(i, facs_coordinates[i][0], facs_coordinates[i][1], 20*Math.random()+50);
            facs[i] = f1;
        }
        for (int i=0; i<points.length;i++){
            Point p1 = new Point (i, points_coordinates[i][0], points_coordinates[i][1], 2*Math.random()+1);
            points[i] = p1;
        }
        double[][] distanceMatrix = operator.distanceMatrix(facs, points);
        ArrayList<Facility> openedFacilities = new ArrayList<>();
        ArrayList<Point> unassignedPoints = new ArrayList<>();
        ArrayList<ArrayList<Point>> assignmentList = new ArrayList<>();





        /// My code is starts from here

        operator.print2d(distanceMatrix); // to see the distance matrix
        System.out.println("\n"+"Respectively: ");// Just an information for next println statement
        int openPnumOfFacs=3; //This is the number of facilities that we wan to open among candidate facilities
        double totalDistance=0; // This value will hold total distances for each row in next for loops
        double minValue= 0; //As a starting point we will set this value to an huge value in order to compare the total distances
        int indexOf=0;// We will store index of fact that we open
        double previousMin=-1;// This is for storeing  previous min value in order to find second-third mins. We set it a negative number which is imposible for distance
        double max=0; //We will find this from the right under for loop then set it to minvalue


        //First we will find an huge value to set min value for compareing
        for(int y=0;y<facs.length;y++){ // in order to set minvalue to a huge value that none of totaldistance does not equal
            totalDistance=0;// we can use this variable in order to find max value as well
            for(int x=0;x<points.length;x++) {
                totalDistance+=distanceMatrix[y][x];
            }
            if(max<totalDistance ){
                max=totalDistance;
            }
        }
        minValue=max+1;//We find the biggest value for us to sen minvalue;




        // Now we will start to open facts

        while(openPnumOfFacs>0){ //Untill locateing p number of facs this loop will continue
            for(int y=0;y<facs.length;y++){ // With this "for loop" each time we will look for thmin total distance
                totalDistance=0;// To find each  rows total distance,each facilties for all points,  we are setting totaldistance 0 each time
                for(int x=0;x<points.length;x++) { //This loop will find each rows "total" distance
                    totalDistance+=distanceMatrix[y][x];
                }


                if(minValue>totalDistance && previousMin<totalDistance){ // With this constraint, we always find the factory with the smallest distance from the previous minimum.
                    minValue=totalDistance;// Updateing min value everytime we enter this if
                    indexOf=y; // We store the index of the minumum we found so that we can open the facility to this locaiton
                }

            }
            //We get out of the first loop we find the min one for each stage

            System.out.println("We are opening facility that has id "+indexOf);

            openedFacilities.add(facs[indexOf]); // We are opening indexOf'th facility
            openPnumOfFacs-=1;// Every time we open a factory, we decrease the number of factories we need to open in total. (İn order to exit the while when we reach the amount of fact that we want to open)
            previousMin=minValue;// İn order to find next minimum we are setting current min to previous min
            minValue=max; // Then setting min to a huge value to run correctly if in next step for next 'th min value


        }

        // Here we will find min distances for each point that an opened fact has and assign it to corresponding fact.
        int index=0; //id of opened each facility
        int factid=0; // factory id that assigned th point
        for(int x=0;x<points.length;x++){
            double min=minValue;
            for(int y=0;y<openedFacilities.size();y++){ // Among the factories we opened, we find which one is closest to point x.
                index=openedFacilities.get(y).id; // we get the id of the first fact that we opened untill the last one.

                if(min>distanceMatrix[index][x]){// Then we find min distance for x point for each column(Among fact that we open)
                    min=distanceMatrix[index][x];
                    factid=index;

                }
            }

            System.out.println("We assigned point "+ (x+1) +"to facility "+ factid); // x+1 beacuse we have customers from1 to 20,(not 0 to 19).


        }





    }
}