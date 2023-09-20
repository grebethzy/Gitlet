package gitlet;

// TODO: any imports you need here

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static gitlet.Repository.*;
import static gitlet.Utils.*;
import static gitlet.myUtils.*;
import gitlet.Blob.*;
import gitlet.Index.*;


/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    // The message of this Commit.
    private String commitMsg;
    // commit time
    private Date commitTime;
    // first parent's SHA1 ID - reference to the blob
    private List<String> parents;
    // a map from filepath to its file/blob ID
    private HashMap<String, String> blobs;
    // own commit SHA1 ID later to generated based on the 4 parts above
    private String commitID;
    private File commitF; // pointer pointing to the file of this commit object

    /* TODO: fill in the rest of this class. */

    /**
     * Creates a dog object with the specified parameters.
     * @param commitMsg commit message
     * // commitTime: time of the new commit
     * // files: the files' ID that this commit is tracking
     */
    public Commit() {
        this.commitMsg = commitMsg;
        this.commitTime = getCommitTime();
        this.parents = new ArrayList<>();
        this.blobs = new HashMap<>();
        this.commitID = generateCommitID();
    }

    public Commit(String commitMsg, List<String> parents, HashMap<String, String> blobs) {
        this.commitMsg = commitMsg;
        this.commitTime = getCommitTime();
        this.parents = parents;
        this.blobs = blobs;
        this.commitID = generateCommitID();
    }

    private Date getCommitTime() {
        return new Date();
    }

    public List<String> getParents() {
        return parents;
    }

    public String getFilePath() {
        return commitF.getPath();
    }

    public HashMap<String, String> getBlobs() { return blobs;}

    public String generateCommitID() {
        return sha1(commitMsg, commitTime, parents.toString(), blobs.toString());
    }

    public String getCommitID() {
        return commitID;
    }

    public void saveCommit() {
        File outFile = getObjectFilebyID(commitID);
        writeObject(outFile, this);
    }
    public void clearStagingArea () {
        blobs.clear();
    }



}
