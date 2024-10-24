import { Grid2} from "@mui/material";

export const CustomGrid = ({children}) => {
    const style = {
        grid: {
            backgroundColor: 'white',
            borderRadius: '10px',
            padding: '10px',
            boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
            width: '50vh',
            alignSelf: 'start',
        },
    }


    return (
        <>
            <Grid2 container rowSpacing={2} columnSpacing={{xs: 1, sm: 1, md: 1}}
                   style={style.grid}
            >
                {
                    children.length > 0 ? children.map((child) => {
                            return (
                                <Grid2 item xs={12} sm={6} md={4} lg={3} xl={2}

                                >
                                    {child}
                                </Grid2>
                            )
                        }
                    ) : <Grid2 item xs={12} sm={6} md={4} lg={3} xl={2}
                               style={style.item}
                    >
                        {children}
                    </Grid2>

                }
            </Grid2>
        </>
    )
}
