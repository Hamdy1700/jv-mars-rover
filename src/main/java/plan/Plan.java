package plan;

public class Plan {

    //TODO: ADD TO CONSIDERATIONS AS WE GO (USEFUL FOR FUTURE DEVELOPMENT)

    //-----TODO: CONSIDERATIONS-----\\

    //TODO MVP:
    //TODO: OUTLINE
    //Validate all inputs
    //On start user picks top-right grid coordinate (thus setting grid size),
    //initial rover grid position, string of movement options
    //  -must be a no move option for 3rd param
    //Generate and render the (rectangular) grid?
    //Size of grid:
    //  On start, user picks coordinates of top-right point
    //  Bottom-left point is always 0,0
    //Movement options: L, R, M
    //NSWE should be enum
    //Track the direction the rover is facing?
    //Move the rover on the grid?
    //CLASSES
    //Part of UI Layer:
    //UI class
    //  -receives input and passes it to logic layer
    //  -outputs result of processes to console
    //Part of Logical Layer:
    //Plateau class
    //  -generate grid (only one) -- look into singleton pattern
    //  -track grid positions of rovers
    //Rover class
    //  -instantiate rovers
    //  -move rovers -- rovers move sequentially (meaning the first must
    //   finish moving before the next can move)
    //TODO: EXCEPTIONS
    //Handle rover out of bounds?
    //  -Ignore commands that move rover out of bounds
    //  -Print out of bounds message to console
    //  Make custom exception RoverOutOfBoundsException
    //  and handle it as above?
    //TODO (LATER):
    //Incorporate multiple rover functionality (details found in brief)
    //Think of other user-friendly considerations (to do with UI, especially
    //what information the user is given about the space they're operating on)



}
