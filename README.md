# X,Y,Z API Developer Test

Programming and Test Automation Exam

For Developers
Write a simple .Net or Java REST API that will accept two parameters
The first parameter is a string that for now can accept X, Y, Z
The second parameter is an integer that can only accept odd integers.

The API must output a string containing ‘*’ that prints the entered letter on the first parameter with the dimension specified by the second parameter.

Your solution must clearly demonstrate good OOP concetps and enables future addition of more letters. 

Attached is the API design on YAML format.
Example 1.
Input = ‘X’
size = 3

request body {"letters": "X", "size": 3}
output JSON = 
[
    {
        "letterGrid": [
            "* *",
            " * ",
            "* *"
        ]
    }
]

Example 2.
Input = ‘XY’
size = 3

request body {"letters": "XY", "size": 3}

output json = 
[
    {
        "letterGrid": [
            "* *",
            " * ",
            "* *"
        ]
    },
    {
        "letterGrid": [
            "* *",
            " * ",
            " * "
        ]
    }
]

Example 3.
Input = ‘XYZ’
size = 3
output string = 
[
    {
        "letterGrid": [
            "* *",
            " * ",
            "* *"
        ]
    },
    {
        "letterGrid": [
            "* *",
            " * ",
            " * "
        ]
    },
    {
        "letterGrid": [
            “***",
            " * ",
            “***"
        ]
    }
]

Example 4.
Input = ‘X’
size = 7
output json = 
[
    {
        "letterGrid": [
            "*     *",
            " *   * ",
            "  * *  ",
            "   *   ",
            "  * *  ",
            " *   * ",
            "*     *"
        ]
    }
]

Example 5.
Input = ‘Z’
size = 5
output string = 
[
    {
        "letterGrid": [
            "*****",
            "   * ",
            "  *  ",
            " *   ",
            "*****"
        ]
    }
]

For full specification of the API please download the attached yaml file
