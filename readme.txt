Purpose
    To validate user input
    To use Toast notification messages
    To implement an event handler for a Button
Functional Requirements for Your Login Example App

Now it's time to add functionality and data validation to your Login Example app.

    As savvy Android developers, we should always consider how to best validate all data entered by the user.

    Steps to follow for input validation:

    select (or make) the proper UI <View>
    set any properties of the <View> that will help with validation
    implement, in Java code, the remaining validation rules not covered by the previous 2 points
    Extend the behaviour of your Login Example app, and implement data validation.

Log In Button
    When the user taps the Log In button:

        validate the username input; refer to the section Input Validation (below) for addition information
        validate the password input; see Input Validation (below)
        success - if and only if ( iff ) all input is valid, then display a Toast message (with a long duration); display the username and password
        Input Validation

Validate the user input for username and password.

    username Validation
        The username is considered valid if each of the following conditions is true:

        the username is mandatory
        the length of the username must be exactly 8 characters in length
        each of the first 2 positions can only be lower-case alphabetic characters (a-z)
        positions 3 and 4 can either be a lower-case alphabetical character (a-z) OR a digit (0-9)
        positions 5 thru 8 (inclusive) must be digits (0-9)
        Note: these validation rules are based on the ITS policy regarding student usernames
        If any one of the above conditions is false, the input for the username is invalid. Implement the following:

        for the username <TextView>  :: use setError( ) to set an appropriate error message
        for the username <TextView> :: request focus (requestFocus())
        Examples with explanation:

        aaaa0000 (valid)
        zzzz9999 (valid)
        AAAA0000 (invalid; upper-case)
        ?0000000 (invalid; non-alphabetical character)
        aa000000 (valid)
        abc12345 (valid)
        aaaa12345 (invalid; too long)
        abcdefgh (invalid; positions 5 thru 8 are not digits)
        a (invalid; too short)

    password Validation
        The password is considered valid if each of the following conditions is true:

        the password is mandatory
        the length of the password is greater than or equal to 5 ( >= 5 )
        If any one of the above conditions is false, the input for the username is invalid. Implement the following:

        for the password <TextView>  :: use setError( ) to set an appropriate error message
        for the password <TextView> :: request focus (requestFocus())