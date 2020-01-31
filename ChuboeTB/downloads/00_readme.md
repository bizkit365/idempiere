The purpose of this plugin is to help you monitor your trial balance quickly and easily across a single or all orgs, accounts, dates, etc...

Recommended Changes (future enhancements):
* none as of now

NOTES:
* Installing this plugin requires you to reboot your server. The reason is that it changes the ColumnName length from 30 to 40
to allow for human readable names. 
* If you have the old version of Trial Balance installed, please perform the following upgrade instructions before installing version 2:


Upgrade Instructions:
drop table chuboe_trialbalance_hdr
Install the 01_SQL file first.
Install the 02_Pack In second. (extends column name to 40)
***RESTART APP SERVER****
Install the 03_Pack In thrid. (install TrialBalance)
Install the 03_Felix Console plugin forth (with start level 5).
