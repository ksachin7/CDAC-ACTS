# Linux Basic
# =====================================================================================================================
# WARNING: This file contains practice commands for review only.
exit 0  # Prevents accidental execution

# 1. How would you display the contents of a text file named "example.txt" in the terminal?
cat example.txt

# 2. What command would you use to list all files and directories in the current directory?
ls -a

# 3. How can you create a new directory named "documents" in the current directory?
mkdir documents

# 4. What command would you use to copy a file named "file1.txt" from the current directory to another directory named "backup"?
cp file1.txt backup/

# 5. How would you navigate to the parent directory of the current directory?
cd ..

# 6. What command would you use to search for the word "apple" in a file named "fruits.txt"?
grep "apple" fruits.txt 

# 7. How can you recursively remove a directory named "old_files" along with all its contents?
rm -rf old_files

# 8. What command would you use to find out the size of a file named "report.pdf" in kilobytes?
ls -sh report.pdf
du -k report.pdf

# 9. How can you rename a file named "oldname.txt" to "newname.txt"?
mv oldname.txt newname.txt

# 10. What command would you use to display the last 10 lines of a file named "logfile.txt"?
tail logfile.txt

# 11. How would you create a new user named "john" on the system?
sudo adduser john

# 12. What command would you use to set the password for the user "john"?
sudo paaswd john

# 13. How can you remove a user named "alice" from the system, along with their home directory and files?
sudo userdel alice
rm -r /home/alice

# 14. What command would you use to grant read and write permissions to the owner, and only read permissions to the group and others, for a file named "data.txt"?
chmod 644 data.txt

# 15. How can you change the owner of a directory named "shared" to the user "bob" and the group "staff"?
sudo chown bob:staff shared 
# bob is the new owner (user)
# staff is the new group
# shared is the directory name
# sudo is needed if you don’t have permission to change ownership