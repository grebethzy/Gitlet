# Gitlet: Java Project at CS61B Spring 21

- Project spec: https://sp21.datastructur.es/materials/proj/proj2/proj2
- Skeleton repo: https://github.com/Berkeley-CS61B/skeleton-sp21
- Gradescope: 1696 / 1600 marks (Access Code: P5WVGW / MB7ZPY)

Gitlet is a simplified version control system inspire by Git, developed as part of the CS61B module from UCB. 
It's designed to help understand the basics of version control operations and Data Structure & Algorithms. 

Gitlet supports most local version control commands, such as creating and managing repositories, committing changes, tracking the history of a project, and more.
In terms of remote commands, Gitlet supports basic ones i.e. pull, push, fetch. 

## File Structure

**``/gitlet`` contains the implementation of Gitlet: **
1. ``Blob.java`` and ``Commit.java`` implement the object blob and commit, served to save contents of a file and snapshot the CWD at each commit. 
2. ``DumpObj.java`` and ``Dumpable.java`` are provided by the module for serializing objects and debugging, ``GitletException.java`` is a custom exception for Gitlet. 
3. ``Index.java`` represents the staging area of Gitlet, ``Remote.java`` manages the connections and operations related to remote Gitlet repositories. 
4. ``Utils.java`` are provided by the module, contains general utility methods such as file operations, ``MyUtils`` are custom utilities defined by the student.
5. ``Repository.java`` encapsulates the key functionality and DSA of Gitlet.
6. ``Main.java`` is the entry point of Gitlet, parses and dispatches commands.
7. ``Makefile`` and ``sentinel`` are provided by the module, for compiling and placeholding purpose respectively.

**``/testing`` contains the testing framework: **
1. ``/samples`` contains test scripts on gradescope, ``/src`` contains files used in test scripts.
2. ``/student_tests`` are self-defined test scripts by the student.
3. ``runner.py`` defines how to run test suites, ``tester.py`` automates the running process.

Others contain root compilation, configuration and markdown files. 

## Setup and Commands Supported

Clone the repo and navigate to the repo folder. Execute each gitlet supported commands by bash in a format of  ``java gitlet.Main [command name] [args for the command]``

Commands are outlined with their key functionabilities. Refer spec for the detailed explaination. 

### Local Commands 
- ``init`` creates a new Git version-control system in the current dir, i.e. .gitlet dir, as the .git created by ``git init``. 
- ``add [file name]`` adds a copy of the file i.e. staging area with new contents. Note Gitlet only supports adding one a single file at a time. 
- ``commit [message]`` saves snapshot of tracked files in the current commit and staging area, so that they can be restored at a later time. Similar to Git but with less metadata.
- ``rm [file name]`` unstages the staged file, or stages for removal and remove from the CWD.
- ``log`` displays information about each commit along the commit tree, starting from the current head commit, excluding the second parent created by merge. Similar to ``git log --first-parent``.
- ``global-log`` displays information about all the commits ever made, the order of the commits does not matter.
- ``find [commit message]`` prints out all the commits' IDs that have the given commit message.
- ``status`` displays branches, staged files, removed files, modifications not staged for commit and untracked files.
- ``checkout`` is a kind of general command. ``checkout -- [file name]`` takes the head-commit version of the file and puts in the CWD, ``checkout [commit id] -- [file name]`` does similar things but with the given commit-id-version. ``checkout [branch name]`` takes all files in the branch's head commit and puts in the CWD.
- ``branch [branch name]`` creates a new branch and points it at the current head commit.
- ``rm-branch [branch name]`` deletes the branch, i.e. only delete the pointer associates with this branch.
- ``reset [commit id]`` checks out all the files tracked by the given commit.
- ``merge [branch name]`` merges files from the given branch into the current branch. Comparably, Git does a more subtle job, e.g. force user to resolve conflicts, and more.

### Remote Commands
- ``add-remote [remote name] [name of remote directory]/.gitlet`` saves the remote dir under the given remote name.
- ``rm-remote [remote name]`` removes the information associated with the the given remote name.
- ``push [remote name] [remote branch name]`` appends the current branch's commits to the end of the given branch at the given remote.
- ``fetch [remote name] [remote branch name]`` copies all blobs and commits from the given branch in the remote repo into local repo in a branch named ``[remote name]/[remote branch name]``.
- ``pull [remote name] [remote branch name]`` fetches branch ``[remote name]/[remote branch name]`` and then merges that branch into the current branch. 
