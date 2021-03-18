import java.util.*;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class InsertInterval {

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> mergedIntervals = new ArrayList<>();
    //TODO: Write your code here
    TreeSet<Interval> timeline = new TreeSet<Interval>(( i1,  i2)-> {
        return i1.start - i2.start;
    });

    for (Interval interval : intervals) {
      timeline.add(interval);
    }

    Interval floor = timeline.floor(newInterval);
    Interval ceil = timeline.ceiling(newInterval);

    if(floor == null && ceil == null) {
          timeline.add(newInterval);
       } else {
         if(floor != null) {
          if(floor.end >= newInterval.start) {
            timeline.remove(floor);
            newInterval.start = floor.start;
            newInterval.end = Math.max(floor.end, newInterval.end);
          }
         }
          if(ceil != null) {
            if(ceil.start <= newInterval.end) {
              timeline.remove(ceil);
              newInterval.end = Math.max(ceil.end, newInterval.end);
            }
          }

          timeline.add(newInterval);
         }
         mergedIntervals = new ArrayList<Interval>(timeline);
    return mergedIntervals;
  }

  public static void main(String[] args) {
      List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}
