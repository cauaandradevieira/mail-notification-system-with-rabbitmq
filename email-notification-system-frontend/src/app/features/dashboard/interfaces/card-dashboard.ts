export interface CardDashboard
{
    icon: string,
    value: number,
    label: string,
    percentage: number,
    iconColor: string,
    iconBackground: string,
    trend: "up" | "down" | "neutral"; 
}