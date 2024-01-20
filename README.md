# Gitlet: Java Project for CS61B Spring '21

- Project spec: https://sp21.datastructur.es/materials/proj/proj2/proj2
- Skeleton repo: https://github.com/Berkeley-CS61B/skeleton-sp21
- Gradescope: 1696 / 1600 marks (Access Code: P5WVGW / MB7ZPY)

Gitlet is a simplified version control system inspired by Git, developed as part of the CS61B course at UCB. 
It's designed to help understand the basics of version control operations and Data Structure & Algorithms. 

Gitlet supports most local version control commands, such as creating and managing repositories, committing changes, tracking the history of a project, and more.
In terms of remote commands, Gitlet supports basic ones, i.e., pull, push, and fetch.

## File Structure

``/gitlet`` contains the implementation of Gitlet: 
1. ``Blob.java`` and ``Commit.java`` implement the object blob and commit, which serve to save the contents of a file and snapshot the CWD at each commit.
2. ``DumpObj.java`` and ``Dumpable.java`` are provided by the module for serializing objects and debugging, ``GitletException.java`` is a custom exception for Gitlet. 
3. ``Index.java`` represents the staging area of Gitlet, ``Remote.java`` manages the connections and operations related to remote Gitlet repositories. 
4. ``Utils.java`` is provided by the module and contains general utility methods such as file operations, while ``MyUtils.java`` contains custom utilities defined by the student.
5. ``Repository.java`` encapsulates the key functionality and DSA of Gitlet.
6. ``Main.java`` is the entry point of Gitlet, parses and dispatches commands.
7. ``Makefile`` and ``sentinel`` are provided by the module for compiling and placeholder purposes, respectively.

``/testing`` contains the testing framework: 
1. ``/samples`` contains test scripts on gradescope, ``/src`` contains files used in test scripts.
2. ``/student_tests`` contain self-defined test scripts by the student.
3. ``runner.py`` defines how to run test suites, while ``tester.py`` automates the running process.

Other files include root compilation, configuration, and markdown files. 

## Setup and Commands Supported

Clone the repo and navigate to the repo folder. Execute each gitlet supported commands by bash in a format of  ``java gitlet.Main [command name] [args for the command]``

Commands are outlined with their key functionalities. Refer to the spec for a detailed explanation.

### Local Commands 
- ``init`` creates a new Git version-control system in the current dir, i.e. .gitlet dir, as the .git created by ``git init``. 
- ``add [file name]`` adds a copy of the file, i.e., to the staging area with new contents. Note: Gitlet only supports adding a single file at a time.
- ``commit [message]`` saves snapshot of tracked files in the current commit and staging area, so that they can be restored at a later time. Similar to Git but with less metadata.
- ``rm [file name]`` unstages the staged file, stages it for removal, and removes it from the CWD.
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
- ``rm-remote [remote name]`` removes the information associated with the given remote name.
- ``push [remote name] [remote branch name]`` appends the current branch's commits to the end of the given branch at the given remote.
- ``fetch [remote name] [remote branch name]`` copies all blobs and commits from the given branch in the remote repository into the local repository in a branch named ``[remote name]/[remote branch name]``.
- ``pull [remote name] [remote branch name]`` fetches branch ``[remote name]/[remote branch name]`` and then merges that branch into the current branch.

## To-improve Fields (for self reference)
- Refactor Repository.java to modularize functionality.
- Reduce code redundancy, particularly with blob and commit retrievals, by helper methods in respective objects.
- Expand and update documentation / comments for clarity in each object.
- Utilize utility methods from the module, like GitletException, more effectively.
- Update gitlet-design.md to reflect design changes at earlier stages.
- Standardize method naming conventions.
