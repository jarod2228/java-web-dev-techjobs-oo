package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

// TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        int numberId = this.getId();
        String nameText = this.getName();
        String employerText = this.getEmployer().getValue();
        String locationText = this.getLocation().getValue();
        String positionText = this.getPositionType().getValue();
        String coreCompetencyText = this.getCoreCompetency().getValue();
        String oops = "OOPS! This job does not seem to exist.";

        boolean name = true;
        boolean employer = true;
        boolean location = true;
        boolean position = true;
        boolean coreCompetency = true;

        if (nameText.equals("")) {
            nameText = "Data not available";
            name = false;
        }
        if (employerText.equals("")) {
            employerText = "Data not available";
            employer = false;
        }
        if (locationText.equals("")) {
            locationText = "Data not available";
            location = false;
        }
        if (positionText.equals("")) {
            positionText = "Data not available";
            position = false;
        }
        if (coreCompetencyText.equals("")) {
            coreCompetencyText = "Data not available";
            coreCompetency = false;
        }
        if (!name && !employer && !location && !position && !coreCompetency) {
            return oops;
        } else {
            String output = String.format("%nID: %d %nName: %s %nEmployer: %s %nLocation: %s %nPosition Type: %s %nCore Competency: %s %n",
                    numberId , nameText, employerText, locationText, positionText, coreCompetencyText);
            return output;
        }
    }
    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

}
