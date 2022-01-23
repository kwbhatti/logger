
# Chimp Cental Logger

Logger utility which creates an HTML log file
which is easier to organize and helps with debugging.


## Features

- Easy to implement
- Logs current data and time, example: 01/23/2022 14:55:38 PM
- Generates on runtime
    - does not need to flush at the end
    - an exception thrown by client does not impact cretion of the file
- Parallel Execution
    - allows the user to create multiple sub logs within the main log
    - also works as a single log without internal logs
- Organization
    - creates sub logs as a list
    - links the logs to the log tables
    - allows to only view a single sub-log at a time
    - allows creation of main logs without sub-logs
    - allows to add nodes within the logs for large log messages like data base query results and api request and responses
- Customization
    - overwrite default logo
    - overwrite default target directory / file name
    - overwrite heading / sub-heading / title
    - add custom logo via source URL
    - add links to GitHub, Jira, mail-to-address
    - remove images
- Methods
    - info (logs info with timestamp)
    - warn (logs warning (in red) with timestamp)
    - toNode (creates collapsible node with timestamp)


## How To ##
Creating a new logger, providing custom options, 
creating sub-logs, and logging information to the 
log file is very simple. See below for details.

### Create new log ###
Upon initializing the Logger class, a new log file is created
with default values. Read more about LoggerOptions for deails 
about default values and over-writing them.\
Log can be initiazed using one of the 2 constructors

#### Without logger options: ####
`Logger myNewLog = new Logger();`

#### With logger options: ####
`Logger myNewLog = new Logger(loggerOptions);`

The above statement takes instance of the the Logger Options class.
See below for more deails about LoggerOptions.
By providing the logger options, the log file will be created
using user provided properties.

#### Logger Options ####
LoggerOptions class allows the user to overwrite the default
values while creating the new log file. The logger options allows
user to change/create:
- Target directory: folder path where log file is created
    - Method: setTargetDir("directory path")
    - Default value: project directory/target which is default for maven projects
- File name: name of the log file
    - Method: setFilename("log file name.html")
    - Default value: logs.html
- Title: title of the HTML page
    - Method: setTitle("HTML page title")
    - Default value: CHIMP CENTRAL
- Heading: heading on top of the page
    - Method: setHeading("heading")
    - Default value: CHIMP CENTRAL
- Sub Heading: sub heading on top under heading
    - Method: setSubHeading("sub heading")
    - Default value: Project Logs
- Logo Source URL: source URL for the log in navigation pane
    - Method: setLogoSrcURL("source URL")
    - Default value: points to Chimp Central logo
- Remove Images: By default the links are created with images/icons. These icon can be removed by calling this method. Keeping the images does not have a significant impact on perfomance.
    - Method: removeImages();
    - Default value: true
Below options are only added to the log file if provided
in the logger options. If the setters are not called for the 
below options, then these would not exist in the log file since 
they are very specific to the user/organization.
- GitHub URL: href URL for the GitHub website
    - Method: setGithubURL("URL to GitHub website")
    - Default value: none
- Jira URL: href URL for the Jira website
    - Method: setJiraURL("URL to Jira website")
    - Default value: none
- Mail To Address: email address for send email link
    - Method: setMailToAddress("email address")
    - Default value: none
Logger Options setters return the instance of the LoggerOptions 
using this keyword and the setters can be called using chains. 
Below are a few examples of initializing LoggerOptions.

#### Logger Options 1 ####

`LoggerOptions myloggeroptions = new LoggerOptions();`\
`myloggeroptions.setTargetDir(System.getProperty("user.dir) + "/myDirectory")`\
`myloggeroptions.setFilename("mylog.html")`\
`myloggeroptions.setHeading("MY HEADING")`\
`myloggeroptions.setGithubURL("https://github.com/kwbhatti/logger")`

#### Logger Options 2 ####
`LoggerOptions myloggeroptions = new LoggerOptions();`\
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
 `.setLogoSrcURL("URL to logo file")`\
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
 `.setTitle("my title")`\
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
 `.setMailToAddress("test-monkey@chimp-central.com")`\
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
 `.removeImages();`


## Authors

- [Khurram Waleed Bhatti](https://www.chimp-central.com)




