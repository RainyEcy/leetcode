package firstbadversion;

public class VersionControl {
    protected int badVersion;

    public boolean isBadVersion(int version) {
        return version == badVersion;
    }
}
