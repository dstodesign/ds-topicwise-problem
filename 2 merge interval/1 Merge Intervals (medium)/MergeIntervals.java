import java.util.*;
import java.lang.Math;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class MergeIntervals {

  public static List<Interval> merge(List<Interval> intervals) {
    List<Interval> mergedIntervals = new LinkedList<Interval>();
    // TODO: Write your code here
    TreeSet<Interval> timeline = new TreeSet<Interval>(( i1,  i2)-> {
        return i1.start - i2.start;
    });

    for (Interval interval : intervals) {
       Interval floor = timeline.floor(interval);
       Interval ceil = timeline.ceiling(interval);
       if(floor == null && ceil == null) {
          timeline.add(interval);
       } else {
         if(floor != null) {
          if(floor.end >= interval.start) {
            timeline.remove(floor);
            interval.start = floor.start;
            interval.end = Math.max(floor.end, interval.end);
          }
         }
          if(ceil != null) {
            if(ceil.start <= interval.end) {
              timeline.remove(ceil);
              interval.end = Math.max(ceil.end, interval.end);
            }
          }

          timeline.add(interval);
         }
         
       }
    

    mergedIntervals = new ArrayList<Interval>(timeline);
    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 11));
    input.add(new Interval(7, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(6, 7));
    input.add(new Interval(2, 4));
    input.add(new Interval(5, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 6));
    input.add(new Interval(3, 5));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}