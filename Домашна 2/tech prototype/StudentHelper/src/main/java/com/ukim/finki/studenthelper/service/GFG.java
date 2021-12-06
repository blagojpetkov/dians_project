package com.ukim.finki.studenthelper.service;

// Java program to calculate Distance Between
// Two Points on Earth

import java.util.Scanner;

class GFG {

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public static double distance1(double lon1, double lat1, double lon2, double lat2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    public static double distance(double lat1,
                                  double lat2, double lon1,
                                  double lon2)
    {

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }

    // driver code
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter latitude of first point");
        double lat1 = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter longitude of first point");
        double lon1 = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter latitude of second point");
        double lat2 = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter longitude of second point");
        double lon2 = Double.parseDouble(scanner.nextLine());
        System.out.println(distance(lat1, lat2, lon1, lon2) + " kilometers");
        System.out.println(distance1(lat1, lat2, lon1, lon2) + " kilometers");
    }
}
//41.9959
//21.4322
//41.8654
//21.9359