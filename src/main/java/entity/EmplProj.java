package entity;

/**
 * Created by user on 4/8/2017.
 */

public class EmplProj {

    private long emlployeeId;
    private long projectId;

    public EmplProj() {
    }

    /**
     * Getter for property 'emlployeeId'.
     *
     * @return Value for property 'emlployeeId'.
     */
    public long getEmlployeeId() {
        return emlployeeId;
    }

    /**
     * Setter for property 'emlployeeId'.
     *
     * @param emlployeeId Value to set for property 'emlployeeId'.
     */
    public void setEmlployeeId(long emlployeeId) {
        this.emlployeeId = emlployeeId;
    }

    /**
     * Getter for property 'projectId'.
     *
     * @return Value for property 'projectId'.
     */
    public long getProjectId() {
        return projectId;
    }

    /**
     * Setter for property 'projectId'.
     *
     * @param projectId Value to set for property 'projectId'.
     */
    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplProj emplProj = (EmplProj) o;

        if (emlployeeId != emplProj.emlployeeId) return false;
        return projectId == emplProj.projectId;
    }

    @Override
    public int hashCode() {
        int result = (int) (emlployeeId ^ (emlployeeId >>> 32));
        result = 31 * result + (int) (projectId ^ (projectId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "EmplProj{" +
                "emlployeeId=" + emlployeeId +
                ", projectId=" + projectId +
                '}';
    }
}
